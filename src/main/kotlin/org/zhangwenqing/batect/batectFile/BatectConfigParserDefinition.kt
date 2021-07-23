package org.zhangwenqing.batect.batectFile

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import generated.GeneratedTypes
import org.zhangwenqing.batect.batectFile.parser.BatectFileParser
import org.zhangwenqing.batect.batectFile.psi.BatectConfigFile

class BatectConfigParserDefinition : ParserDefinition
{
	override fun createLexer(project: Project): Lexer
	{
		return BatectLexerAdapter()
	}

	override fun getWhitespaceTokens(): TokenSet
	{
		return WHITE_SPACES
	}

	override fun getCommentTokens(): TokenSet
	{
		return COMMENTS
	}

	override fun getStringLiteralElements(): TokenSet
	{
		return TokenSet.EMPTY
	}

	override fun createParser(project: Project): PsiParser
	{
		return BatectFileParser()
	}

	override fun getFileNodeType(): IFileElementType
	{
		return FILE
	}

	override fun createFile(viewProvider: FileViewProvider): PsiFile
	{
		return BatectConfigFile(viewProvider)
	}

	override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements
	{
		return SpaceRequirements.MAY
	}

	override fun createElement(node: ASTNode): PsiElement
	{
		return GeneratedTypes.Factory.createElement(node)
	}

	companion object
	{
		val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
		val COMMENTS = TokenSet.create(GeneratedTypes.COMMENT)
		val FILE = IFileElementType(BatectConfigLanguage.INSTANCE)
	}
}
