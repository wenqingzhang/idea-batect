package org.zhangwenqing.jetbrains.batect.actions

import com.intellij.ide.actions.CreateFileAction.MkDirs
import com.intellij.ide.fileTemplates.FileTemplate
import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.ide.fileTemplates.actions.CreateFromTemplateActionBase
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteActionAware
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.SmartPointerManager
import com.intellij.util.IncorrectOperationException
import icons.BatectIcons
import org.apache.velocity.runtime.parser.ParseException
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.zhangwenqing.jetbrains.BatectBundle

const val NEW_BATECT_CONFIG_FILE_NAME = "batect.yml"
const val NEW_BATECT_CONFIG_TEMPLATE_NAME = "Batect Config Template"

class CreateBatectConfigFileAction : AnAction(
  @Suppress("DialogTitleCapitalization")
  BatectBundle.message("batect.new.yaml.file.action"),
  BatectBundle.message("batect.new.yaml.file.action.description"),
  BatectIcons.batectFile
), DumbAware, WriteActionAware
{
	private val logger = Logger.getInstance(CreateBatectConfigFileAction::class.java)

	override fun actionPerformed(e: AnActionEvent)
	{
		val view = e.getData(LangDataKeys.IDE_VIEW) ?: return
		val project = e.getData(CommonDataKeys.PROJECT) ?: return
		val directory = view.orChooseDirectory ?: return

		val filename = NEW_BATECT_CONFIG_FILE_NAME

		val file = directory.findFile(filename)
		var virtualFile = file?.virtualFile ?: directory.virtualFile.findChild(filename)
		if (file == null || virtualFile == null)
		{
			virtualFile = createBatectConfigFile(directory)?.virtualFile
		}
		if (virtualFile != null)
		{
			FileEditorManager.getInstance(project)
			  .openFile(virtualFile, true)
		}
	}

	private fun createBatectConfigFile(@NotNull dir: PsiDirectory): PsiFile?
	{
		val template = FileTemplateManager.getInstance(dir.project)
		  .getInternalTemplate(NEW_BATECT_CONFIG_TEMPLATE_NAME)
		return createBatectConfigFileFromTemplate(template, dir)
	}

	@Nullable
	private fun createBatectConfigFileFromTemplate(
	  @NotNull template: FileTemplate,
	  @NotNull dir: PsiDirectory
	): PsiFile?
	{
		val mkdirs = MkDirs(NEW_BATECT_CONFIG_FILE_NAME, dir)
		val newName = mkdirs.newName
		val directory = mkdirs.directory

		val project = directory.project
		try
		{
			val psiFile = FileTemplateUtil.createFromTemplate(
			  template,
			  newName,
			  FileTemplateManager.getInstance(dir.project).defaultProperties,
			  directory
			).containingFile
			val pointer = SmartPointerManager.getInstance(project)
			  .createSmartPsiElementPointer(psiFile)
			val virtualFile = psiFile.virtualFile
			if (virtualFile != null)
			{
				if (template.isLiveTemplateEnabled)
				{
					CreateFromTemplateActionBase.startLiveTemplate(psiFile, emptyMap())
				}
				else
				{
					FileEditorManager.getInstance(project).openFile(virtualFile, true)
				}

				return pointer.element
			}
		}
		catch (e: ParseException)
		{
			throw IncorrectOperationException("Error parsing Velocity template: ${e.message}", e as Throwable);
		}
		catch (e: IncorrectOperationException)
		{
			throw e
		}
		catch (e: Exception)
		{
			logger.error(e)
		}
		return null
	}

	@Suppress("ComplexCondition")
	override fun update(e: AnActionEvent)
	{
		val project = e.getData(CommonDataKeys.PROJECT)
		val view = e.getData(LangDataKeys.IDE_VIEW)
		val directory = view?.directories
		if (project == null || directory == null || directory.isEmpty())
		{
			e.presentation.isVisible = false
		}
	}
}
