// This is a generated file. Not intended for manual editing.
package org.zhangwenqing.batect.batectFile.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static generated.GeneratedTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.zhangwenqing.batect.batectFile.psi.*;

public class BatectPropertyValueImpl extends ASTWrapperPsiElement implements BatectPropertyValue {

  public BatectPropertyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitPropertyValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatectPropertyList2 getPropertyList2() {
    return findChildByClass(BatectPropertyList2.class);
  }

  @Override
  @Nullable
  public PsiElement getBash() {
    return findChildByType(BASH);
  }

  @Override
  @Nullable
  public PsiElement getImageVersion() {
    return findChildByType(IMAGE_VERSION);
  }

  @Override
  @Nullable
  public PsiElement getPlainText() {
    return findChildByType(PLAIN_TEXT);
  }

}
