package org.zhangwenqing.batect.parser.psi

import com.intellij.psi.PsiElement
import org.jetbrains.annotations.Nullable

interface BatectValue: BatectPsiElement
{
	@Nullable
	fun getTag(): PsiElement?
}
