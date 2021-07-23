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

public class BatectTasksImpl extends ASTWrapperPsiElement implements BatectTasks {

  public BatectTasksImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitTasks(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BatectTasksKey getTasksKey() {
    return findNotNullChildByClass(BatectTasksKey.class);
  }

  @Override
  @NotNull
  public BatectTasksValue getTasksValue() {
    return findNotNullChildByClass(BatectTasksValue.class);
  }

}
