package icons

import com.intellij.ui.IconManager
import org.jetbrains.annotations.NotNull

object BatectIcons
{
	@JvmStatic
	@NotNull
	private fun getIcon(@NotNull path: String) =
	  IconManager.getInstance().getIcon(path, BatectIcons::class.java)

	@JvmStatic
	@NotNull
	val batect = getIcon("icons/batect.svg")

	@JvmStatic
	@NotNull
	val batectFile = getIcon("icons/batect.svg")
}
