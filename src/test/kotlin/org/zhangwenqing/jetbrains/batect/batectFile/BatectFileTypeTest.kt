package org.zhangwenqing.jetbrains.batect.batectFile

import com.intellij.mock.MockVirtualFile
import icons.BatectIcons
import org.junit.Test
import org.zhangwenqing.jetbrains.util.Constants
import org.zhangwenqing.jetbrains.Common
import java.lang.reflect.InvocationTargetException

class BatectFileTypeTest : Common<BatectFileType>()
{
	@Test
	@Throws(
	  InvocationTargetException::class,
	  NoSuchMethodException::class,
	  InstantiationException::class,
	  IllegalAccessException::class
	)
	fun testPrivateConstructor()
	{
		privateConstructor(BatectFileType::class.java)
	}

	@Test
	fun testGetName()
	{
		assertEquals(
		  Constants.BATECT,
		  BatectFileType.BATECT_FILE_TYPE.name
		)
	}

	@Test
	fun getDescription()
	{
		assertEquals(
		  Constants.BATECT,
		  BatectFileType.BATECT_FILE_TYPE.description
		)
	}

	@Test
	fun getDefaultExtension()
	{
		assertEquals(
		  Constants.BATECT_EXTENSION,
		  BatectFileType.BATECT_FILE_TYPE.defaultExtension
		)
	}

	@Test
	fun getIcon()
	{
		assertEquals(
		  BatectIcons.batectFile,
		  BatectFileType.BATECT_FILE_TYPE.icon
		)
	}

	@Test
	fun getCharset()
	{
		assertEquals(
		  Constants.CHARSET,
		  BatectFileType.BATECT_FILE_TYPE.getCharset(MockVirtualFile.file("dummy"), ByteArray(1))
		)
	}
}
