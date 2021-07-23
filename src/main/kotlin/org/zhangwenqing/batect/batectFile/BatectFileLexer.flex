package org.zhangwenqing.batect.batectFile;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static generated.GeneratedTypes.*;

%%

%{
  public _BatectFileLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _BatectFileLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

COMMENT=(#)[^\r\n]*
PLAIN_TEXT=[a-zA-Z][a-zA-Z0-9_\-.]*[a-zA-Z0-9]
BASH=[\w'\".\-_;>&!]*
IMAGE_VERSION=[a-zA-Z0-9][a-zA-Z0-9_\-.]*[a-zA-Z0-9]

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  " "                  { return WHITE_SPACE; }
  "  "                 { return INDENT_LEVEL1; }
  "    "               { return INDENT_LEVEL2; }
  "      "             { return INDENT_LEVEL3; }
  ":"                  { return COLON; }
  "EOL"                { return EOL; }

  {COMMENT}            { return COMMENT; }
  {PLAIN_TEXT}         { return PLAIN_TEXT; }
  {BASH}               { return BASH; }
  {IMAGE_VERSION}      { return IMAGE_VERSION; }

}

[^] { return BAD_CHARACTER; }
