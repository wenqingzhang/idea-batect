package org.zhangwenqing.batect.run

import com.intellij.execution.TestStateStorage
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiUtilCore
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.zhangwenqing.batect.parser.psi.BatectElementTypes
import org.zhangwenqing.batect.util.Utils

class BatectTaskRunLineMarkerContributor : RunLineMarkerContributor()
{
	private val RUN_LINE_MARKER_ELEMENTS = TokenSet.create(BatectElementTypes.TASKS_KEYWORD)

	@Nullable
	override fun getInfo(@NotNull element: PsiElement): Info?
	{
		if (element !is LeafElement)
		{
			return null;
		}

		val type = PsiUtilCore.getElementType(element as PsiElement)
		if (!RUN_LINE_MARKER_ELEMENTS.contains(type))
		{
			return null
		}

		val url = element.containingFile.virtualFile.url + ":" + Utils.getLineNumber(element)
		val state = TestStateStorage.getInstance(element.project).getState(url)
		return withExecutorActions(getTestStateIcon(state, true))
	}
}
