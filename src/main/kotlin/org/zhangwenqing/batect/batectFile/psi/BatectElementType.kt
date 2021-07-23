package org.zhangwenqing.batect.batectFile.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage

class BatectElementType(@NotNull @NonNls debugName: String) : IElementType(debugName, BatectConfigLanguage.INSTANCE)
