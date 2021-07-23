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

public class BatectBatectPropertyListImpl extends ASTWrapperPsiElement implements BatectBatectPropertyList {

  public BatectBatectPropertyListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitBatectPropertyList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatectConfigVariables getConfigVariables() {
    return findChildByClass(BatectConfigVariables.class);
  }

  @Override
  @Nullable
  public BatectContainers getContainers() {
    return findChildByClass(BatectContainers.class);
  }

  @Override
  @Nullable
  public BatectInclude getInclude() {
    return findChildByClass(BatectInclude.class);
  }

  @Override
  @Nullable
  public BatectProjectName getProjectName() {
    return findChildByClass(BatectProjectName.class);
  }

  @Override
  @Nullable
  public BatectTasks getTasks() {
    return findChildByClass(BatectTasks.class);
  }

}
