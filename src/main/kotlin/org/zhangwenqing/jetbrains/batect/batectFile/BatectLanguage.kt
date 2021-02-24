package org.zhangwenqing.jetbrains.batect.batectFile

import com.intellij.lang.Language;
import org.zhangwenqing.jetbrains.util.Constants.BATECT_LANGUAGE_ID

class BatectLanguage private constructor() : Language(BATECT_LANGUAGE_ID)
{
	companion object
	{
		@JvmStatic
		val INSTANCE = BatectLanguage()
	}
}
