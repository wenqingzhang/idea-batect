package org.zhangwenqing.jetbrains

import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vcs.changes.ignore.psi.IgnoreEntry
import com.intellij.openapi.vcs.changes.ignore.psi.IgnoreVisitor
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier

import org.zhangwenqing.jetbrains.util.Constants

@Suppress("UnnecessaryAbstractClass")
abstract class Common<T> : BasePlatformTestCase()
{
	@Throws(
	  NoSuchMethodException::class,
	  IllegalAccessException::class,
	  InvocationTargetException::class,
	  InstantiationException::class
	)
	protected fun privateConstructor(clz: Class<T>) {
		val constructor = clz.getDeclaredConstructor()
		TestCase.assertTrue(Modifier.isPrivate(constructor.modifiers))
		constructor.isAccessible = true
		constructor.newInstance()
	}

	protected fun createIgnoreContent(vararg entries: String?) =
	  StringUtil.join(entries, Constants.NEWLINE)

	protected val fixtureRootFile
		get() = myFixture.file.containingDirectory.virtualFile

	protected val fixtureChildrenEntries: List<IgnoreEntry>
		get() {
			val children: MutableList<IgnoreEntry> = mutableListOf()
			myFixture.file.acceptChildren(
			  object : IgnoreVisitor() {
				  override fun visitEntry(entry: IgnoreEntry) {
					  children.add(entry)
				  }
			  }
			)
			return children
		}
}
