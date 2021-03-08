package org.zhangwenqing.batect.parser.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import org.jetbrains.annotations.NotNull
import org.zhangwenqing.batect.parser.psi.BatectPsiElement

open class BatectPsiElementImpl constructor(@NotNull node: ASTNode) : ASTWrapperPsiElement(node), BatectPsiElement
{
	override fun toString(): String = "Batect config element"
}
