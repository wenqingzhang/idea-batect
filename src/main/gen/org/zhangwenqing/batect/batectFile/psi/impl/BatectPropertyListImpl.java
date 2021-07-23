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

public class BatectPropertyListImpl extends ASTWrapperPsiElement implements BatectPropertyList {

  public BatectPropertyListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitPropertyList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BatectPropertyKey getPropertyKey() {
    return findNotNullChildByClass(BatectPropertyKey.class);
  }

  @Override
  @NotNull
  public BatectPropertyList getPropertyList() {
    return findNotNullChildByClass(BatectPropertyList.class);
  }

  @Override
  @NotNull
  public BatectPropertyValue getPropertyValue() {
    return findNotNullChildByClass(BatectPropertyValue.class);
  }

}
