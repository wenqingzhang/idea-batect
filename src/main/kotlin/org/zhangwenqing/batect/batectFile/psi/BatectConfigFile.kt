package org.zhangwenqing.batect.batectFile.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.zhangwenqing.batect.batectFile.BatectConfigFileType
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage

class BatectConfigFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, BatectConfigLanguage.INSTANCE)
{
	override fun getFileType(): FileType
	{
		return BatectConfigFileType.BATECT_CONFIG_FILE_TYPE
	}

	override fun toString(): String
	{
		return "bactect config file"
	}
}
