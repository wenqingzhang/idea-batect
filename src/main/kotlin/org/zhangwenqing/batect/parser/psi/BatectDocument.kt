package org.zhangwenqing.batect.parser.psi


interface BatectDocument : BatectPsiElement
{
	fun getTopLevelValue(): BatectValue?

	fun getProjectName(): BatectProjectNameElement?

	fun getConfigVariables(): List<BatectConfigVariable>?

	fun getContainers(): List<BatectContainerElement>?

	fun getInclude(): BatectIncludeElement?

	fun getTasks(): List<BatectTaskElement>?
}
