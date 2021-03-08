package org.zhangwenqing.batect.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import org.jetbrains.annotations.NotNull
import org.jetbrains.yaml.YAMLElementTypes
import org.jetbrains.yaml.YAMLParserDefinition
import org.zhangwenqing.batect.parser.psi.impl.BatectDocumentImpl
import org.zhangwenqing.batect.parser.psi.BatectElementTypes
import org.zhangwenqing.batect.parser.psi.impl.BatectFileImpl

class BatectParserDefinition : YAMLParserDefinition(), ParserDefinition
{
	override fun createElement(@NotNull node: ASTNode): PsiElement
	{
		val type = node.elementType
		when {
			type == YAMLElementTypes.DOCUMENT -> return BatectDocumentImpl(node)
		}

		return super.createElement(node)
	}

	override fun createParser(project: Project?): PsiParser = BatectParser()

	override fun createFile(viewProvider: FileViewProvider): PsiFile = BatectFileImpl(viewProvider)

	override fun getFileNodeType(): IFileElementType = BatectElementTypes.FILE
}
