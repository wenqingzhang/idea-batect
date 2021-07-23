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

public class BatectContainerImageItemImpl extends ASTWrapperPsiElement implements BatectContainerImageItem {

  public BatectContainerImageItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BatectVisitor visitor) {
    visitor.visitContainerImageItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BatectVisitor) accept((BatectVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BatectContainerImageCommandKey getContainerImageCommandKey() {
    return findChildByClass(BatectContainerImageCommandKey.class);
  }

  @Override
  @Nullable
  public BatectContainerImageCommandValue getContainerImageCommandValue() {
    return findChildByClass(BatectContainerImageCommandValue.class);
  }

  @Override
  @Nullable
  public BatectContainerImageImageKey getContainerImageImageKey() {
    return findChildByClass(BatectContainerImageImageKey.class);
  }

  @Override
  @Nullable
  public BatectContainerImageImageValue getContainerImageImageValue() {
    return findChildByClass(BatectContainerImageImageValue.class);
  }

}
