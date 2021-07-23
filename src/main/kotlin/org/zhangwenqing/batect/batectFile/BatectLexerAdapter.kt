package org.zhangwenqing.batect.batectFile

import com.intellij.lexer.FlexAdapter

class BatectLexerAdapter : FlexAdapter(_BatectFileLexer(null))
{
}
