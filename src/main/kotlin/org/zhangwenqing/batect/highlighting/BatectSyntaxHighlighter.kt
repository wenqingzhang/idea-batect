package org.zhangwenqing.batect.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.jetbrains.yaml.YAMLSyntaxHighlighter
import org.zhangwenqing.batect.parser.psi.BatectElementTypes

class BatectSyntaxHighlighter : YAMLSyntaxHighlighter()
{
	companion object
	{
		private var ATTRIBUTES: Map<IElementType, TextAttributesKey> = hashMapOf(
		  Pair(BatectElementTypes.PROJECT_NAME_KEYWORD, BatectHighlighter.PROJECT_NAME),
		  Pair(BatectElementTypes.CONFIG_VARIABLES_KEYWORD, BatectHighlighter.CONFIG_VARIABLES),
		  Pair(BatectElementTypes.CONTAINERS_KEYWORD, BatectHighlighter.CONTAINERS),
		  Pair(BatectElementTypes.CONTAINER_NAME_KEYWORD, BatectHighlighter.CONTAINER_NAME),
		  Pair(BatectElementTypes.INCLUDE_KEYWORD, BatectHighlighter.INCLUDE),
		  Pair(BatectElementTypes.TASKS_KEYWORD, BatectHighlighter.TASKS),
		  Pair(BatectElementTypes.TASK_NAME_KEYWORD, BatectHighlighter.TASK_NAME),
		)
	}

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey>
	{
		return if (ATTRIBUTES.containsKey(tokenType))
		{
			SyntaxHighlighterBase.pack(ATTRIBUTES[tokenType])
		}
		else super.getTokenHighlights(tokenType)
	}
}
