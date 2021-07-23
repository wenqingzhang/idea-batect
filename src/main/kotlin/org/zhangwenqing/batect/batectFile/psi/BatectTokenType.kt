package org.zhangwenqing.batect.batectFile.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage

class BatectTokenType(@NotNull @NonNls debugName: String) : IElementType(debugName, BatectConfigLanguage.INSTANCE)
{
	override fun toString(): String
	{
		return "BatectTokenType." + super.toString()
	}
}
