package org.zhangwenqing.batect.parser.psi

import com.intellij.psi.NavigatablePsiElement
import java.util.ArrayList

interface BatectPsiElement : NavigatablePsiElement
{
	fun getBatectElements(): List<BatectPsiElement>
	{
		val result = ArrayList<BatectPsiElement>()
		for (node in node.getChildren(null))
		{
			val psi = node.psi
			if (psi is BatectPsiElement)
			{
				result.add(psi)
			}
		}
		return result
	}
}
