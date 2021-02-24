package org.zhangwenqing.jetbrains.batect.batectFile

import com.intellij.lang.Language;
import org.zhangwenqing.jetbrains.util.Constants.BATECT_CONFIG_LANGUAGE_ID

class BatectConfigLanguage private constructor() : Language(BATECT_CONFIG_LANGUAGE_ID)
{
	companion object
	{
		@JvmStatic
		val INSTANCE = BatectConfigLanguage()
	}
}
