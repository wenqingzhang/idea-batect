package org.zhangwenqing.batect.parser.psi.impl

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.TokenSet
import org.jetbrains.yaml.YAMLElementTypes
import org.jetbrains.yaml.psi.YAMLDocument
import org.jetbrains.yaml.psi.YAMLFile
import org.zhangwenqing.batect.batectFile.BatectConfigFileType
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage
import java.util.*

class BatectFileImpl
constructor(view: FileViewProvider) : PsiFileBase(view, BatectConfigLanguage.INSTANCE), YAMLFile
{
	override fun getFileType(): FileType = BatectConfigFileType.BATECT_CONFIG_FILE_TYPE

	override fun toString() = "batect.yml"

	override fun getDocuments(): List<YAMLDocument>
	{
		val result = ArrayList<YAMLDocument>()
		for (node in node.getChildren(TokenSet.create(YAMLElementTypes.DOCUMENT)))
		{
			result.add(node.psi as YAMLDocument)
		}
		return result
	}
}
