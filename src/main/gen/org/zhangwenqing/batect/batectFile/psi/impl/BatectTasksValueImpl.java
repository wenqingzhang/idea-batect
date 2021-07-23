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

public class BatectTasksValueImpl extends ASTWrapperPsiElement implements BatectTasksValue {

  public BatectTasksValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitTasksValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatectTaskList getTaskList() {
    return findChildByClass(BatectTaskList.class);
  }

  @Override
  @Nullable
  public PsiElement getPlainText() {
    return findChildByType(PLAIN_TEXT);
  }

}
