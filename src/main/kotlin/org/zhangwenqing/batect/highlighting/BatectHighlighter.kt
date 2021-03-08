package org.zhangwenqing.batect.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import org.jetbrains.annotations.NonNls

object BatectHighlighter
{
	@NonNls
	val PROJECT_NAME_ID = "BATECT_PROJECT_NAME"

	@NonNls
	val CONFIG_VARIABLES_ID = "BATECT_CONFIG_VARIABLES"

	@NonNls
	val CONTAINERS_ID = "BATECT_CONTAINERS"

	@NonNls
	val CONTAINER_NAME_ID = "BATECT_CONTAINER_NAME"

	@NonNls
	val INCLUDE_ID = "BATECT_INCLUDE"

	@NonNls
	val TASKS_ID = "BATECT_TASKS"

	@NonNls
	val TASK_NAME_ID = "BATECT_TASK_NAME"


	val PROJECT_NAME = TextAttributesKey
	  .createTextAttributesKey(PROJECT_NAME_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val CONFIG_VARIABLES = TextAttributesKey
	  .createTextAttributesKey(CONFIG_VARIABLES_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val CONTAINERS = TextAttributesKey
	  .createTextAttributesKey(CONTAINERS_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val CONTAINER_NAME = TextAttributesKey
	  .createTextAttributesKey(CONTAINER_NAME_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val INCLUDE = TextAttributesKey
	  .createTextAttributesKey(INCLUDE_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val TASKS = TextAttributesKey
	  .createTextAttributesKey(TASKS_ID, DefaultLanguageHighlighterColors.KEYWORD)

	val TASK_NAME = TextAttributesKey
	  .createTextAttributesKey(TASK_NAME_ID, DefaultLanguageHighlighterColors.KEYWORD)
}
