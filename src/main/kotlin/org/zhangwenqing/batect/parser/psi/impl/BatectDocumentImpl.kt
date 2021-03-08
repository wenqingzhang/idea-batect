package org.zhangwenqing.batect.parser.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.annotations.NotNull
import org.zhangwenqing.batect.parser.psi.*

class BatectDocumentImpl(@NotNull node: ASTNode) : BatectPsiElementImpl(node), BatectDocument
{
	override fun getTopLevelValue(): BatectValue? =
	  PsiTreeUtil.findChildOfType(this, BatectValue::class.java)

	override fun getProjectName(): BatectProjectNameElement?
	{
		TODO("Not yet implemented")
	}

	override fun getConfigVariables(): List<BatectConfigVariable>?
	{
		TODO("Not yet implemented")
	}

	override fun getContainers(): List<BatectContainerElement>?
	{
		TODO("Not yet implemented")
	}

	override fun getInclude(): BatectIncludeElement?
	{
		TODO("Not yet implemented")
	}

	override fun getTasks(): List<BatectTaskElement>?
	{
		TODO("Not yet implemented")
	}

	override fun toString(): String = "Batect config document"

	//	override fun accept(visitor: PsiElementVisitor)
	//	{
	//		if (visitor is YamlPsiElementVisitor)
	//		{
	//			visitor.visitDocument(this)
	//		}
	//		else
	//		{
	//			super.accept(visitor)
	//		}
	//	}
}
