package org.zhangwenqing.jetbrains.batect.batectFile

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import icons.BatectIcons
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull
import org.zhangwenqing.jetbrains.util.Constants
import javax.swing.Icon

class BatectFileType private constructor() : LanguageFileType(BatectLanguage.INSTANCE)
{
	companion object
	{
		@JvmStatic
		val BATECT_FILE_TYPE = BatectFileType()
	}

	@NotNull
	@NonNls
	override fun getName(): String = Constants.BATECT

	@NonNls
	@NotNull
	override fun getDescription(): String = Constants.BATECT

	@NotNull
	@NonNls
	override fun getDefaultExtension(): String = Constants.BATECT_EXTENSION

	override fun getIcon(): Icon = BatectIcons.batectFile

	override fun getCharset(@NotNull file: VirtualFile, content: ByteArray): String = Constants.CHARSET
}
