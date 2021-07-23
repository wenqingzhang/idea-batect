// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.zhangwenqing.batect.batectFile.psi.BatectElementType;
import org.zhangwenqing.batect.batectFile.psi.BatectTokenType;
import org.zhangwenqing.batect.batectFile.psi.impl.*;

public interface GeneratedTypes {

  IElementType BATECT_PROPERTY_LIST = new BatectElementType("BATECT_PROPERTY_LIST");
  IElementType CONFIG_VARIABLES = new BatectElementType("CONFIG_VARIABLES");
  IElementType CONFIG_VARIABLE_KEY = new BatectElementType("CONFIG_VARIABLE_KEY");
  IElementType CONFIG_VARIABLE_VALUE = new BatectElementType("CONFIG_VARIABLE_VALUE");
  IElementType CONTAINERS = new BatectElementType("CONTAINERS");
  IElementType CONTAINERS_KEY = new BatectElementType("CONTAINERS_KEY");
  IElementType CONTAINERS_VALUE = new BatectElementType("CONTAINERS_VALUE");
  IElementType CONTAINER_IMAGE_COMMAND_KEY = new BatectElementType("CONTAINER_IMAGE_COMMAND_KEY");
  IElementType CONTAINER_IMAGE_COMMAND_VALUE = new BatectElementType("CONTAINER_IMAGE_COMMAND_VALUE");
  IElementType CONTAINER_IMAGE_IMAGE_KEY = new BatectElementType("CONTAINER_IMAGE_IMAGE_KEY");
  IElementType CONTAINER_IMAGE_IMAGE_VALUE = new BatectElementType("CONTAINER_IMAGE_IMAGE_VALUE");
  IElementType CONTAINER_IMAGE_ITEM = new BatectElementType("CONTAINER_IMAGE_ITEM");
  IElementType CONTAINER_LIST = new BatectElementType("CONTAINER_LIST");
  IElementType CONTAINER_NAME = new BatectElementType("CONTAINER_NAME");
  IElementType CONTAINER_PROPERTY_LIST = new BatectElementType("CONTAINER_PROPERTY_LIST");
  IElementType INCLUDE = new BatectElementType("INCLUDE");
  IElementType INCLUDE_KEY = new BatectElementType("INCLUDE_KEY");
  IElementType INCLUDE_VALUE = new BatectElementType("INCLUDE_VALUE");
  IElementType PROJECT_NAME = new BatectElementType("PROJECT_NAME");
  IElementType PROJECT_NAME_KEY = new BatectElementType("PROJECT_NAME_KEY");
  IElementType PROJECT_NAME_VALUE = new BatectElementType("PROJECT_NAME_VALUE");
  IElementType PROPERTY_KEY = new BatectElementType("PROPERTY_KEY");
  IElementType PROPERTY_LIST = new BatectElementType("PROPERTY_LIST");
  IElementType PROPERTY_LIST_2 = new BatectElementType("PROPERTY_LIST_2");
  IElementType PROPERTY_VALUE = new BatectElementType("PROPERTY_VALUE");
  IElementType RUN_PROPERTY_LIST = new BatectElementType("RUN_PROPERTY_LIST");
  IElementType TASKS = new BatectElementType("TASKS");
  IElementType TASKS_KEY = new BatectElementType("TASKS_KEY");
  IElementType TASKS_VALUE = new BatectElementType("TASKS_VALUE");
  IElementType TASK_IMAGE_ITEM = new BatectElementType("TASK_IMAGE_ITEM");
  IElementType TASK_IMAGE_RUN_ITEM = new BatectElementType("TASK_IMAGE_RUN_ITEM");
  IElementType TASK_LIST = new BatectElementType("TASK_LIST");
  IElementType TASK_NAME = new BatectElementType("TASK_NAME");
  IElementType TASK_PROPERTY_LIST = new BatectElementType("TASK_PROPERTY_LIST");

  IElementType BASH = new BatectTokenType("BASH");
  IElementType COLON = new BatectTokenType(":");
  IElementType COMMENT = new BatectTokenType("COMMENT");
  IElementType EOL = new BatectTokenType("EOL");
  IElementType IMAGE_VERSION = new BatectTokenType("IMAGE_VERSION");
  IElementType INDENT_LEVEL1 = new BatectTokenType("  ");
  IElementType INDENT_LEVEL2 = new BatectTokenType("    ");
  IElementType INDENT_LEVEL3 = new BatectTokenType("      ");
  IElementType PLAIN_TEXT = new BatectTokenType("PLAIN_TEXT");
  IElementType WHITE_SPACE = new BatectTokenType(" ");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BATECT_PROPERTY_LIST) {
        return new BatectBatectPropertyListImpl(node);
      }
      else if (type == CONFIG_VARIABLES) {
        return new BatectConfigVariablesImpl(node);
      }
      else if (type == CONFIG_VARIABLE_KEY) {
        return new BatectConfigVariableKeyImpl(node);
      }
      else if (type == CONFIG_VARIABLE_VALUE) {
        return new BatectConfigVariableValueImpl(node);
      }
      else if (type == CONTAINERS) {
        return new BatectContainersImpl(node);
      }
      else if (type == CONTAINERS_KEY) {
        return new BatectContainersKeyImpl(node);
      }
      else if (type == CONTAINERS_VALUE) {
        return new BatectContainersValueImpl(node);
      }
      else if (type == CONTAINER_IMAGE_COMMAND_KEY) {
        return new BatectContainerImageCommandKeyImpl(node);
      }
      else if (type == CONTAINER_IMAGE_COMMAND_VALUE) {
        return new BatectContainerImageCommandValueImpl(node);
      }
      else if (type == CONTAINER_IMAGE_IMAGE_KEY) {
        return new BatectContainerImageImageKeyImpl(node);
      }
      else if (type == CONTAINER_IMAGE_IMAGE_VALUE) {
        return new BatectContainerImageImageValueImpl(node);
      }
      else if (type == CONTAINER_IMAGE_ITEM) {
        return new BatectContainerImageItemImpl(node);
      }
      else if (type == CONTAINER_LIST) {
        return new BatectContainerListImpl(node);
      }
      else if (type == CONTAINER_NAME) {
        return new BatectContainerNameImpl(node);
      }
      else if (type == CONTAINER_PROPERTY_LIST) {
        return new BatectContainerPropertyListImpl(node);
      }
      else if (type == INCLUDE) {
        return new BatectIncludeImpl(node);
      }
      else if (type == INCLUDE_KEY) {
        return new BatectIncludeKeyImpl(node);
      }
      else if (type == INCLUDE_VALUE) {
        return new BatectIncludeValueImpl(node);
      }
      else if (type == PROJECT_NAME) {
        return new BatectProjectNameImpl(node);
      }
      else if (type == PROJECT_NAME_KEY) {
        return new BatectProjectNameKeyImpl(node);
      }
      else if (type == PROJECT_NAME_VALUE) {
        return new BatectProjectNameValueImpl(node);
      }
      else if (type == PROPERTY_KEY) {
        return new BatectPropertyKeyImpl(node);
      }
      else if (type == PROPERTY_LIST) {
        return new BatectPropertyListImpl(node);
      }
      else if (type == PROPERTY_LIST_2) {
        return new BatectPropertyList2Impl(node);
      }
      else if (type == PROPERTY_VALUE) {
        return new BatectPropertyValueImpl(node);
      }
      else if (type == RUN_PROPERTY_LIST) {
        return new BatectRunPropertyListImpl(node);
      }
      else if (type == TASKS) {
        return new BatectTasksImpl(node);
      }
      else if (type == TASKS_KEY) {
        return new BatectTasksKeyImpl(node);
      }
      else if (type == TASKS_VALUE) {
        return new BatectTasksValueImpl(node);
      }
      else if (type == TASK_IMAGE_ITEM) {
        return new BatectTaskImageItemImpl(node);
      }
      else if (type == TASK_IMAGE_RUN_ITEM) {
        return new BatectTaskImageRunItemImpl(node);
      }
      else if (type == TASK_LIST) {
        return new BatectTaskListImpl(node);
      }
      else if (type == TASK_NAME) {
        return new BatectTaskNameImpl(node);
      }
      else if (type == TASK_PROPERTY_LIST) {
        return new BatectTaskPropertyListImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
