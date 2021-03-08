package org.zhangwenqing.batect.util

import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import org.jetbrains.annotations.NotNull

object Utils
{
	@JvmStatic
	fun getLineNumber(@NotNull element: PsiElement): Int?
	{
		val containingFile = element.containingFile
		val project: Project = containingFile.project
		val psiDocumentManager = PsiDocumentManager.getInstance(project)
		val document: Document? = psiDocumentManager.getDocument(containingFile)
		val textOffset = element.textOffset
		return if (document == null)
		{
			null
		}
		else document.getLineNumber(textOffset) + 1
	}
}
