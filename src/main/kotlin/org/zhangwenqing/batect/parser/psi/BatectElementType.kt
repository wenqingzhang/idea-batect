package org.zhangwenqing.batect.parser.psi

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage

class BatectElementType
constructor(@NotNull @NonNls debugName: String) : IElementType(debugName, BatectConfigLanguage.INSTANCE)
{
}
