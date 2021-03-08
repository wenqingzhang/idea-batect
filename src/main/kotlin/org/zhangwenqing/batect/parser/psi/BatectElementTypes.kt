package org.zhangwenqing.batect.parser.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.jetbrains.yaml.YAMLElementType
import org.zhangwenqing.batect.batectFile.BatectConfigLanguage

object BatectElementTypes
{
	val FILE: IFileElementType = IFileElementType(BatectConfigLanguage.INSTANCE)

	val DOCUMENT = BatectElementType("Document ---")

	val CONFIG_VARIABLES_KEYWORD: IElementType = BatectElementType ("config_variables")
	val CONTAINERS_KEYWORD: IElementType = BatectElementType ("containers")
	val INCLUDE_KEYWORD: IElementType = BatectElementType ("include")
	val TASKS_KEYWORD: IElementType = BatectElementType ("tasks")

	val PROJECT_NAME_KEYWORD: IElementType = BatectElementType ("project_name")
	val CONTAINER_NAME_KEYWORD: IElementType = BatectElementType ("container_name")
	val TASK_NAME_KEYWORD: IElementType = BatectElementType ("task_name")
}
