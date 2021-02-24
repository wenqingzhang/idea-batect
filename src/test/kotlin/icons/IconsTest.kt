package icons

import org.junit.Test
import org.zhangwenqing.jetbrains.Common
import java.lang.reflect.InvocationTargetException

class IconsTest : Common<BatectIcons>() {

	@Test
	@Throws(
	  InvocationTargetException::class,
	  NoSuchMethodException::class,
	  InstantiationException::class,
	  IllegalAccessException::class
	)
	fun testPrivateConstructor() {
		privateConstructor(BatectIcons::class.java)
	}
}
