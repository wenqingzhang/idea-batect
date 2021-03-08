package org.zhangwenqing.batect.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lang.WhitespacesAndCommentsBinder.TokenTextGetter
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.util.containers.Stack
import org.jetbrains.annotations.NotNull
import org.jetbrains.yaml.YAMLBundle
import org.jetbrains.yaml.YAMLElementTypes
import org.jetbrains.yaml.YAMLTokenTypes
import org.jetbrains.yaml.parser.YAMLParser

class BatectParser : PsiParser
{

	private class ParseContext constructor(@NotNull val builder: PsiBuilder)
	{
		var myIndent = 0
		val myStopTokensStack = Stack<TokenSet>()

		private var myEolSeen = false
		private var myAfterLastEolMarker: PsiBuilder.Marker? = null


		val eolSeen: Boolean get() = myEolSeen

		fun resetEolSeen()
		{
			myEolSeen = false
		}

		fun dropEolMarker()
		{
			if (myAfterLastEolMarker != null)
			{
				myAfterLastEolMarker!!.drop()
				myAfterLastEolMarker = null
			}
		}

		fun rollBackToEol()
		{
			if (myEolSeen && myAfterLastEolMarker != null)
			{
				resetEolSeen()
				myAfterLastEolMarker!!.rollbackTo()
				myAfterLastEolMarker = null
			}
		}

		fun mark(): PsiBuilder.Marker
		{
			dropEolMarker()
			return builder.mark()
		}

		fun passJunk()
		{
			while (!eof() && isJunk())
			{
				advanceLexer()
			}
		}

		fun isJunk(): Boolean
		{
			val type = getTokenType()
			return type === YAMLTokenTypes.INDENT || type === YAMLTokenTypes.EOL
		}

		private fun getCurrentTokenLength(): Int = builder.rawTokenTypeStart(1) - builder.currentOffset

		fun getTokenType(): IElementType? = if (eof()) null else builder.tokenType

		fun eof(): Boolean = builder.eof() || builder.tokenType === YAMLTokenTypes.DOCUMENT_MARKER

		fun advanceLexer()
		{
			if (builder.eof())
			{
				return
			}
			val type = builder.tokenType
			val eolElement = YAMLElementTypes.EOL_ELEMENTS.contains(type)
			myEolSeen = myEolSeen || eolElement
			when
			{
				eolElement ->
				{
					// Drop and create new eolMarker
					myAfterLastEolMarker = mark()
					myIndent = 0
				}
				type === YAMLTokenTypes.INDENT ->
				{
					myIndent = getCurrentTokenLength()
				}
				else ->
				{
					// Drop Eol Marker if other token seen
					dropEolMarker()
				}
			}

			builder.advanceLexer()
		}

		fun includeBlockEmptyTail(indent: Int)
		{
			if (indent == 0)
			{
				// top-level block with zero indent
				while (isJunk())
				{
					if (
					  getTokenType() === YAMLTokenTypes.EOL &&
					  !YAMLElementTypes.BLANK_ELEMENTS.contains(builder.lookAhead(1))
					)
					{
						// do not include last \n into block
						break
					}
					advanceLexer()
					dropEolMarker()
				}
			}
			else
			{
				var endOfBlock = mark()
				while (isJunk())
				{
					if (getTokenType() === YAMLTokenTypes.INDENT && getCurrentTokenLength() >= indent)
					{
						dropEolMarker()
						endOfBlock.drop()
						advanceLexer()
						endOfBlock = mark()
					}
					else
					{
						advanceLexer()
						dropEolMarker()
					}
				}
				endOfBlock.rollbackTo()
			}
		}

		fun getIndentBonus(insideSequence: Boolean): Int =
		  if (!insideSequence && getTokenType() === YAMLTokenTypes.SEQUENCE_MARKER) 1 else 0

		fun getShorthandIndentAddition(): Int
		{
			val offset = builder.currentOffset
			val nextToken = builder.lookAhead(1)
			if (nextToken !== YAMLTokenTypes.SEQUENCE_MARKER && nextToken !== YAMLTokenTypes.SCALAR_KEY)
			{
				return 1
			}
			return if (builder.rawLookup(1) === YAMLTokenTypes.WHITESPACE)
			{
				builder.rawTokenTypeStart(2) - offset
			}
			else
			{
				1
			}
		}

		fun setStopToken(token: TokenSet) = myStopTokensStack.add(token)
	}

	@NotNull
	override fun parse(@NotNull root: IElementType, @NotNull builder: PsiBuilder): ASTNode
	{
		val context = ParseContext(builder)
		val fileMarker = context.mark()
		parseFile(context)
		assert(builder.eof()) { "Not all tokens were passed." }
		fileMarker.done(root)
		return builder.treeBuilt
	}

	private fun parseFile(@NotNull context: ParseContext)
	{
		val marker = context.mark()
		context.passJunk()
		if (context.builder.tokenType !== YAMLTokenTypes.DOCUMENT_MARKER)
		{
			context.dropEolMarker()
			marker.rollbackTo()
		}
		else
		{
			marker.drop()
		}
		do
		{
			parseDocument(context)
			context.passJunk()
		}
		while (!context.builder.eof())
		context.dropEolMarker()
	}

	private fun parseDocument(@NotNull context: ParseContext)
	{
		val marker = context.mark()
		if (context.builder.tokenType === YAMLTokenTypes.DOCUMENT_MARKER)
		{
			context.advanceLexer()
		}
		parseBlockNode(context, context.myIndent, false)
		context.dropEolMarker()
		marker.done(YAMLElementTypes.DOCUMENT)
	}

	private fun parseBlockNode(@NotNull context: ParseContext, indent: Int, insideSequence: Boolean)
	{
		// Preserve most test and current behaviour for most general cases without comments
		if (context.getTokenType() === YAMLTokenTypes.EOL)
		{
			context.advanceLexer()
			if (context.getTokenType() === YAMLTokenTypes.INDENT)
			{
				context.advanceLexer()
			}
		}
		val marker = context.mark()
		context.passJunk()
		var endOfNodeMarker: PsiBuilder.Marker? = null
		var nodeType: IElementType? = null


		// It looks like tag for a block node should be located on a separate line
		if (context.getTokenType() === YAMLTokenTypes.TAG && context.builder.lookAhead(1) === YAMLTokenTypes.EOL)
		{
			context.advanceLexer()
		}
		var numberOfItems = 0
		while (
		  !context.eof() &&
		  (context.isJunk() || !context.eolSeen || context.myIndent + context.getIndentBonus(insideSequence) >= indent)
		)
		{
			if (context.isJunk())
			{
				context.advanceLexer()
				continue
			}
			if (!context.myStopTokensStack.isEmpty() && context.myStopTokensStack.peek().contains(context.getTokenType()))
			{
				context.rollBackToEol()
				break
			}
			numberOfItems++
			val parsedTokenType = parseSingleStatement(
			  context,
			  if (context.eolSeen) context.myIndent else indent,
			  indent
			)
			if (nodeType == null)
			{
				when
				{
					parsedTokenType === YAMLElementTypes.SEQUENCE_ITEM ->
					{
						nodeType = YAMLElementTypes.SEQUENCE
					}
					parsedTokenType === YAMLElementTypes.KEY_VALUE_PAIR ->
					{
						nodeType = YAMLElementTypes.MAPPING
					}
					numberOfItems > 1 ->
					{
						nodeType = YAMLElementTypes.COMPOUND_VALUE
					}
				}
			}
			endOfNodeMarker?.drop()
			endOfNodeMarker = context.mark()
		}
		if (endOfNodeMarker != null)
		{
			context.dropEolMarker()
			endOfNodeMarker.rollbackTo()
		}
		else
		{
			context.rollBackToEol()
		}
		context.includeBlockEmptyTail(indent)
		if (nodeType != null)
		{
			marker.done(nodeType)
			marker.setCustomEdgeTokenBinders(
			  { tokens: List<IElementType>, _: Boolean, _: TokenTextGetter? -> findLeftRange(tokens) }
			) { tokens: List<IElementType>, _: Boolean, _: TokenTextGetter? -> tokens.size }
		}
		else
		{
			marker.drop()
		}
	}

	private fun parseSingleStatement(@NotNull context: ParseContext, indent: Int, minIndent: Int): IElementType?
	{
		if (context.eof())
		{
			return null
		}
		val marker = context.mark()
		parseNodeProperties(context)
		val tokenType = context.getTokenType()
		val nodeType: IElementType?
		if (tokenType === YAMLTokenTypes.LBRACE)
		{
			nodeType = parseHash(context)
		}
		else if (tokenType === YAMLTokenTypes.LBRACKET)
		{
			nodeType = parseArray(context)
		}
		else if (tokenType === YAMLTokenTypes.SEQUENCE_MARKER)
		{
			nodeType = parseSequenceItem(context, indent)
		}
		else if (tokenType === YAMLTokenTypes.QUESTION)
		{
			nodeType = parseExplicitKeyValue(context, indent)
		}
		else if (tokenType === YAMLTokenTypes.SCALAR_KEY)
		{
			nodeType = parseScalarKeyValue(context, indent)
		}
		else if (YAMLElementTypes.SCALAR_VALUES.contains(context.getTokenType()))
		{
			nodeType = parseScalarValue(context, minIndent)
		}
		else if (tokenType === YAMLTokenTypes.STAR)
		{
			val aliasMarker = context.mark()
			context.advanceLexer() // symbol *
			if (context.getTokenType() === YAMLTokenTypes.ALIAS)
			{
				context.advanceLexer() // alias name
				aliasMarker.done(YAMLElementTypes.ALIAS_NODE)
				if (context.getTokenType() === YAMLTokenTypes.COLON)
				{
					// Alias is used as key name
					context.resetEolSeen()
					val indentAddition: Int = context.getShorthandIndentAddition()
					nodeType = parseSimpleScalarKeyValueFromColon(context, indent, indentAddition)
				}
				else
				{
					// simple ALIAS_NODE was constructed and marker should be dropped
					marker.drop()
					return YAMLElementTypes.ALIAS_NODE
				}
			}
			else
			{
				// Should be impossible now (because of lexer rules)
				aliasMarker.drop()
				nodeType = null
			}
		}
		else
		{
			context.advanceLexer()
			nodeType = null
		}
		if (nodeType != null)
		{
			marker.done(nodeType)
		}
		else
		{
			marker.drop()
		}
		return nodeType
	}

	private fun parseNodeProperties(@NotNull context: ParseContext)
	{
		// By standard here could be no more than one TAG or ANCHOR
		// By better to support sequence of them
		var anchorWasRead = false
		var tagWasRead = false
		while (context.getTokenType() === YAMLTokenTypes.TAG || context.getTokenType() === YAMLTokenTypes.AMPERSAND)
		{
			if (context.getTokenType() === YAMLTokenTypes.AMPERSAND)
			{
				var errorMarker: PsiBuilder.Marker? = null
				if (anchorWasRead)
				{
					errorMarker = context.mark()
				}
				anchorWasRead = true
				val anchorMarker = context.mark()
				context.advanceLexer() // symbol &
				if (context.getTokenType() === YAMLTokenTypes.ANCHOR)
				{
					context.advanceLexer() // anchor name
					anchorMarker.done(YAMLElementTypes.ANCHOR_NODE)
				}
				else
				{
					// Should be impossible now (because of lexer rules)
					anchorMarker.drop()
				}
				errorMarker?.error(YAMLBundle.message("YAMLParser.multiple.anchors"))
			}
			else
			{ // tag case
				if (tagWasRead)
				{
					val errorMarker = context.mark()
					context.advanceLexer()
					errorMarker.error(YAMLBundle.message("YAMLParser.multiple.tags"))
				}
				else
				{
					tagWasRead = true
					context.advanceLexer()
				}
			}
		}
	}

	private fun parseScalarValue(@NotNull context: ParseContext, indent: Int): IElementType?
	{
		val tokenType = context.getTokenType()
		assert(YAMLElementTypes.SCALAR_VALUES.contains(tokenType)) { "Scalar value expected!" }
		return if (tokenType === YAMLTokenTypes.SCALAR_LIST || tokenType === YAMLTokenTypes.SCALAR_TEXT)
		{
			parseMultiLineScalar(context, tokenType)
		}
		else if (tokenType === YAMLTokenTypes.TEXT)
		{
			parseMultiLinePlainScalar(context, indent)
		}
		else if (tokenType === YAMLTokenTypes.SCALAR_DSTRING || tokenType === YAMLTokenTypes.SCALAR_STRING)
		{
			parseQuotedString(context)
		}
		else
		{
			context.advanceLexer()
			null
		}
	}

	private fun parseQuotedString(@NotNull context: ParseContext): IElementType
	{
		context.advanceLexer()
		return YAMLElementTypes.SCALAR_QUOTED_STRING
	}

	private fun parseMultiLineScalar(@NotNull context: ParseContext, tokenType: IElementType): IElementType
	{
		assert(tokenType === context.getTokenType())
		// Accept header token: '|' or '>'
		context.advanceLexer()

		// Parse header tail: TEXT is used as placeholder for invalid symbols in this context
		if (context.getTokenType() === YAMLTokenTypes.TEXT)
		{
			val err = context.builder.mark()
			context.advanceLexer()
			err.error(YAMLBundle.message("YAMLParser.invalid.header.symbols"))
		}
		if (YAMLElementTypes.EOL_ELEMENTS.contains(context.getTokenType()))
		{
			context.advanceLexer()
		}
		var endOfValue: PsiBuilder.Marker? = context.builder.mark()
		var type = context.getTokenType()
		// Lexer ensures such input token structure: ( ( INDENT tokenType? )? SCALAR_EOL )*
		// endOfValue marker is needed to exclude INDENT after last SCALAR_EOL
		while (type === tokenType || type === YAMLTokenTypes.INDENT || type === YAMLTokenTypes.SCALAR_EOL)
		{
			context.advanceLexer()
			if (type === tokenType)
			{
				endOfValue?.drop()
				endOfValue = null
			}
			if (type === YAMLTokenTypes.SCALAR_EOL)
			{
				endOfValue?.drop()
				endOfValue = context.builder.mark()
			}
			type = context.getTokenType()
		}
		endOfValue?.rollbackTo()
		return if (tokenType === YAMLTokenTypes.SCALAR_LIST) YAMLElementTypes.SCALAR_LIST_VALUE else YAMLElementTypes.SCALAR_TEXT_VALUE
	}

	private fun parseMultiLinePlainScalar(@NotNull context: ParseContext, indent: Int): IElementType
	{
		var lastTextEnd: PsiBuilder.Marker? = null
		var type = context.getTokenType()
		while (type === YAMLTokenTypes.TEXT || type === YAMLTokenTypes.INDENT || type === YAMLTokenTypes.EOL)
		{
			context.advanceLexer()
			if (type === YAMLTokenTypes.TEXT)
			{
				if (lastTextEnd != null && context.myIndent < indent)
				{
					break
				}
				lastTextEnd?.drop()
				lastTextEnd = context.mark()
			}
			type = context.getTokenType()
		}
		context.rollBackToEol()
		assert(lastTextEnd != null)
		lastTextEnd!!.rollbackTo()
		return YAMLElementTypes.SCALAR_PLAIN_VALUE
	}

	private fun parseExplicitKeyValue(@NotNull context: ParseContext, indent: Int): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.QUESTION)
		var indentAddition = context.getShorthandIndentAddition()
		context.advanceLexer()
		if (!context.myStopTokensStack.isEmpty() && context.myStopTokensStack.peek() == YAMLParser.HASH_STOP_TOKENS // This means we're inside some hash
		  && context.getTokenType() === YAMLTokenTypes.SCALAR_KEY
		)
		{
			parseScalarKeyValue(context, indent)
		}
		else
		{
			context.myStopTokensStack.add(TokenSet.create(YAMLTokenTypes.COLON))
			context.resetEolSeen()
			parseBlockNode(context, indent + indentAddition, false)
			context.myStopTokensStack.pop()
			context.passJunk()
			if (context.getTokenType() === YAMLTokenTypes.COLON)
			{
				indentAddition = context.getShorthandIndentAddition()
				context.advanceLexer()
				context.resetEolSeen()
				parseBlockNode(context, indent + indentAddition, false)
			}
		}
		return YAMLElementTypes.KEY_VALUE_PAIR
	}

	private fun parseScalarKeyValue(@NotNull context: ParseContext, indent: Int): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.SCALAR_KEY) { "Expected scalar key" }
		context.resetEolSeen()
		val indentAddition = context.getShorthandIndentAddition()
		context.advanceLexer()
		return parseSimpleScalarKeyValueFromColon(context, indent, indentAddition)
	}

	private fun parseSimpleScalarKeyValueFromColon(@NotNull context: ParseContext, indent: Int, indentAddition: Int): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.COLON) { "Expected colon" }
		context.advanceLexer()
		val rollbackMarker = context.mark()
		context.passJunk()
		if (context.eolSeen && (context.eof() || context.myIndent + context.getIndentBonus(false) < indent + indentAddition))
		{
			context.dropEolMarker()
			rollbackMarker.rollbackTo()
		}
		else
		{
			context.dropEolMarker()
			rollbackMarker.rollbackTo()
			parseBlockNode(context, indent + indentAddition, false)
		}
		return YAMLElementTypes.KEY_VALUE_PAIR
	}

	private fun parseSequenceItem(@NotNull context: ParseContext, indent: Int): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.SEQUENCE_MARKER)
		val indentAddition = context.getShorthandIndentAddition()
		context.advanceLexer()
		context.resetEolSeen()
		parseBlockNode(context, indent + indentAddition, true)
		context.rollBackToEol()
		return YAMLElementTypes.SEQUENCE_ITEM
	}

	private fun parseHash(@NotNull context: ParseContext): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.LBRACE)
		context.advanceLexer()
		context.myStopTokensStack.add(YAMLParser.HASH_STOP_TOKENS)
		while (!context.eof())
		{
			if (context.getTokenType() === YAMLTokenTypes.RBRACE)
			{
				context.advanceLexer()
				break
			}
			parseSingleStatement(context, 0, 0)
		}
		context.myStopTokensStack.pop()
		context.dropEolMarker()
		return YAMLElementTypes.HASH
	}

	private fun parseArray(@NotNull context: ParseContext): IElementType
	{
		assert(context.getTokenType() === YAMLTokenTypes.LBRACKET)
		context.advanceLexer()
		context.setStopToken(YAMLParser.ARRAY_STOP_TOKENS)
		while (!context.eof())
		{
			if (context.getTokenType() === YAMLTokenTypes.RBRACKET)
			{
				context.advanceLexer()
				break
			}
			if (context.isJunk())
			{
				context.advanceLexer()
				continue
			}
			val marker = context.mark()
			val parsedElement = parseSingleStatement(context, 0, 0)
			if (parsedElement != null)
			{
				marker.done(YAMLElementTypes.SEQUENCE_ITEM)
			}
			else
			{
				marker.error(YAMLBundle.message("parsing.error.sequence.item.expected"))
			}
			if (context.getTokenType() === YAMLTokenTypes.COMMA)
			{
				context.advanceLexer()
			}
		}
		context.myStopTokensStack.pop()
		context.dropEolMarker()
		return YAMLElementTypes.ARRAY
	}

	companion object
	{
		private fun findLeftRange(tokens: List<IElementType>): Int
		{
			val i = tokens.indexOf(YAMLTokenTypes.COMMENT)
			return if (i != -1) i else tokens.size
		}
	}
}
