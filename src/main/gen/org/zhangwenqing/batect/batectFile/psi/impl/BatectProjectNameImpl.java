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

public class BatectProjectNameImpl extends ASTWrapperPsiElement implements BatectProjectName {

  public BatectProjectNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitProjectName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BatectProjectNameKey getProjectNameKey() {
    return findNotNullChildByClass(BatectProjectNameKey.class);
  }

  @Override
  @NotNull
  public BatectProjectNameValue getProjectNameValue() {
    return findNotNullChildByClass(BatectProjectNameValue.class);
  }

}
