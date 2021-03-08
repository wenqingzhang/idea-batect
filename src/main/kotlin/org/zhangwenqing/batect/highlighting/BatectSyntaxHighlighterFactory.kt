package org.zhangwenqing.batect.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.annotations.NotNull


class BatectSyntaxHighlighterFactory : SyntaxHighlighterFactory()
{
	@NotNull
	override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter
	{
		return BatectSyntaxHighlighter()
	}
}
