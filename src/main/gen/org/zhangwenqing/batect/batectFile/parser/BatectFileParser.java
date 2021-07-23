// This is a generated file. Not intended for manual editing.
package org.zhangwenqing.batect.batectFile.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static generated.GeneratedTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BatectFileParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return batect_file(b, l + 1);
  }

  /* ********************************************************** */
  // batect-property-list*
  static boolean batect_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batect_file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!batect_property_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "batect_file", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // project_name |
  //     config_variables |
  //     containers |
  //     include |
  //     tasks
  public static boolean batect_property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batect_property_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BATECT_PROPERTY_LIST, "<batect property list>");
    r = project_name(b, l + 1);
    if (!r) r = config_variables(b, l + 1);
    if (!r) r = containers(b, l + 1);
    if (!r) r = include(b, l + 1);
    if (!r) r = tasks(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'config_variables'
  public static boolean config_variable_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variable_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_VARIABLE_KEY, "<config variable key>");
    r = consumeToken(b, "config_variables");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT | (INDENT_LEVEL1 property-list)
  public static boolean config_variable_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variable_value")) return false;
    if (!nextTokenIs(b, "<config variable value>", INDENT_LEVEL1, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_VARIABLE_VALUE, "<config variable value>");
    r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = config_variable_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INDENT_LEVEL1 property-list
  private static boolean config_variable_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variable_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL1);
    r = r && property_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // config_variable_key WHITE_SPACE* COLON WHITE_SPACE* config_variable_value EOL*
  public static boolean config_variables(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variables")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_VARIABLES, "<config variables>");
    r = config_variable_key(b, l + 1);
    r = r && config_variables_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && config_variables_3(b, l + 1);
    r = r && config_variable_value(b, l + 1);
    r = r && config_variables_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean config_variables_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variables_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "config_variables_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean config_variables_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variables_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "config_variables_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean config_variables_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_variables_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "config_variables_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'command'
  public static boolean container_image_command_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_command_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_IMAGE_COMMAND_KEY, "<container image command key>");
    r = consumeToken(b, "command");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BASH
  public static boolean container_image_command_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_command_value")) return false;
    if (!nextTokenIs(b, BASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BASH);
    exit_section_(b, m, CONTAINER_IMAGE_COMMAND_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // 'image'
  public static boolean container_image_image_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_image_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_IMAGE_IMAGE_KEY, "<container image image key>");
    r = consumeToken(b, "image");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT COLON IMAGE_VERSION
  public static boolean container_image_image_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_image_value")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PLAIN_TEXT, COLON, IMAGE_VERSION);
    exit_section_(b, m, CONTAINER_IMAGE_IMAGE_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // container-image-image-key WHITE_SPACE* COLON WHITE_SPACE* container-image-image-value EOL* |
  //     container-image-command-key WHITE_SPACE* COLON WHITE_SPACE* container-image-command-value EOL*
  public static boolean container_image_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_IMAGE_ITEM, "<container image item>");
    r = container_image_item_0(b, l + 1);
    if (!r) r = container_image_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // container-image-image-key WHITE_SPACE* COLON WHITE_SPACE* container-image-image-value EOL*
  private static boolean container_image_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = container_image_image_key(b, l + 1);
    r = r && container_image_item_0_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && container_image_item_0_3(b, l + 1);
    r = r && container_image_image_value(b, l + 1);
    r = r && container_image_item_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean container_image_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_0_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean container_image_item_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_0_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean container_image_item_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_0_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_0_5", c)) break;
    }
    return true;
  }

  // container-image-command-key WHITE_SPACE* COLON WHITE_SPACE* container-image-command-value EOL*
  private static boolean container_image_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = container_image_command_key(b, l + 1);
    r = r && container_image_item_1_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && container_image_item_1_3(b, l + 1);
    r = r && container_image_command_value(b, l + 1);
    r = r && container_image_item_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean container_image_item_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_1_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean container_image_item_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_1_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean container_image_item_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_image_item_1_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "container_image_item_1_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // container-name WHITE_SPACE* COLON WHITE_SPACE* EOL INDENT_LEVEL2 container-property-list EOL*
  public static boolean container_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_list")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = container_name(b, l + 1);
    r = r && container_list_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && container_list_3(b, l + 1);
    r = r && consumeTokens(b, 0, EOL, INDENT_LEVEL2);
    r = r && container_property_list(b, l + 1);
    r = r && container_list_7(b, l + 1);
    exit_section_(b, m, CONTAINER_LIST, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean container_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_list_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean container_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_list_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean container_list_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_list_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "container_list_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PLAIN_TEXT
  public static boolean container_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_name")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAIN_TEXT);
    exit_section_(b, m, CONTAINER_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // container-image-item WHITE_SPACE* EOL*
  public static boolean container_property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_property_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_PROPERTY_LIST, "<container property list>");
    r = container_image_item(b, l + 1);
    r = r && container_property_list_1(b, l + 1);
    r = r && container_property_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean container_property_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_property_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "container_property_list_1", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean container_property_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_property_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "container_property_list_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // containers-key WHITE_SPACE* COLON WHITE_SPACE* containers-value EOL*
  public static boolean containers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINERS, "<containers>");
    r = containers_key(b, l + 1);
    r = r && containers_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && containers_3(b, l + 1);
    r = r && containers_value(b, l + 1);
    r = r && containers_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean containers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "containers_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean containers_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "containers_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean containers_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "containers_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'containers'
  public static boolean containers_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINERS_KEY, "<containers key>");
    r = consumeToken(b, "containers");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (INDENT_LEVEL1 container-list) | PLAIN_TEXT
  public static boolean containers_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_value")) return false;
    if (!nextTokenIs(b, "<containers value>", INDENT_LEVEL1, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINERS_VALUE, "<containers value>");
    r = containers_value_0(b, l + 1);
    if (!r) r = consumeToken(b, PLAIN_TEXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INDENT_LEVEL1 container-list
  private static boolean containers_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containers_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL1);
    r = r && container_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // include-key WHITE_SPACE* COLON WHITE_SPACE* include-value EOL*
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, "<include>");
    r = include_key(b, l + 1);
    r = r && include_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && include_3(b, l + 1);
    r = r && include_value(b, l + 1);
    r = r && include_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean include_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "include_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean include_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "include_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean include_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "include_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'include'
  public static boolean include_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_KEY, "<include key>");
    r = consumeToken(b, "include");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT | property-list*
  public static boolean include_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_VALUE, "<include value>");
    r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = include_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // property-list*
  private static boolean include_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "include_value_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // project_name_key WHITE_SPACE* COLON WHITE_SPACE* project_name_value EOL*
  public static boolean project_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROJECT_NAME, "<project name>");
    r = project_name_key(b, l + 1);
    r = r && project_name_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && project_name_3(b, l + 1);
    r = r && project_name_value(b, l + 1);
    r = r && project_name_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean project_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "project_name_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean project_name_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "project_name_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean project_name_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "project_name_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'project_name'
  public static boolean project_name_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROJECT_NAME_KEY, "<project name key>");
    r = consumeToken(b, "project_name");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT
  public static boolean project_name_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "project_name_value")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAIN_TEXT);
    exit_section_(b, m, PROJECT_NAME_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT
  public static boolean property_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_key")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAIN_TEXT);
    exit_section_(b, m, PROPERTY_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // (INDENT_LEVEL1 property-key WHITE_SPACE* COLON property-value EOL*) property-list
  public static boolean property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list")) return false;
    if (!nextTokenIs(b, INDENT_LEVEL1)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_list_0(b, l + 1);
    r = r && property_list(b, l + 1);
    exit_section_(b, m, PROPERTY_LIST, r);
    return r;
  }

  // INDENT_LEVEL1 property-key WHITE_SPACE* COLON property-value EOL*
  private static boolean property_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL1);
    r = r && property_key(b, l + 1);
    r = r && property_list_0_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && property_value(b, l + 1);
    r = r && property_list_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean property_list_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "property_list_0_2", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean property_list_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list_0_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "property_list_0_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (INDENT_LEVEL2 property-key WHITE_SPACE* COLON property-value EOL*) property-list2
  public static boolean property_list2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list2")) return false;
    if (!nextTokenIs(b, INDENT_LEVEL2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_list2_0(b, l + 1);
    r = r && property_list2(b, l + 1);
    exit_section_(b, m, PROPERTY_LIST_2, r);
    return r;
  }

  // INDENT_LEVEL2 property-key WHITE_SPACE* COLON property-value EOL*
  private static boolean property_list2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL2);
    r = r && property_key(b, l + 1);
    r = r && property_list2_0_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && property_value(b, l + 1);
    r = r && property_list2_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean property_list2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "property_list2_0_2", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean property_list2_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_list2_0_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "property_list2_0_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // property-list2 | PLAIN_TEXT COLON IMAGE_VERSION | PLAIN_TEXT | BASH
  public static boolean property_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_VALUE, "<property value>");
    r = property_list2(b, l + 1);
    if (!r) r = parseTokens(b, 0, PLAIN_TEXT, COLON, IMAGE_VERSION);
    if (!r) r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = consumeToken(b, BASH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INDENT_LEVEL3 task-image-run-item WHITE_SPACE* EOL*
  public static boolean run_property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "run_property_list")) return false;
    if (!nextTokenIs(b, INDENT_LEVEL3)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL3);
    r = r && task_image_run_item(b, l + 1);
    r = r && run_property_list_2(b, l + 1);
    r = r && run_property_list_3(b, l + 1);
    exit_section_(b, m, RUN_PROPERTY_LIST, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean run_property_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "run_property_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "run_property_list_2", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean run_property_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "run_property_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "run_property_list_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'description' WHITE_SPACE* COLON WHITE_SPACE* PLAIN_TEXT EOL* |
  //     'run' WHITE_SPACE* COLON WHITE_SPACE* EOL run-property-list EOL*
  public static boolean task_image_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TASK_IMAGE_ITEM, "<task image item>");
    r = task_image_item_0(b, l + 1);
    if (!r) r = task_image_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'description' WHITE_SPACE* COLON WHITE_SPACE* PLAIN_TEXT EOL*
  private static boolean task_image_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "description");
    r = r && task_image_item_0_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && task_image_item_0_3(b, l + 1);
    r = r && consumeToken(b, PLAIN_TEXT);
    r = r && task_image_item_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_image_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_0_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean task_image_item_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_0_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean task_image_item_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_0_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_0_5", c)) break;
    }
    return true;
  }

  // 'run' WHITE_SPACE* COLON WHITE_SPACE* EOL run-property-list EOL*
  private static boolean task_image_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "run");
    r = r && task_image_item_1_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && task_image_item_1_3(b, l + 1);
    r = r && consumeToken(b, EOL);
    r = r && run_property_list(b, l + 1);
    r = r && task_image_item_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_image_item_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_1_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean task_image_item_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_1_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean task_image_item_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_item_1_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "task_image_item_1_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "container" WHITE_SPACE* COLON WHITE_SPACE* PLAIN_TEXT |
  //     'command' WHITE_SPACE* COLON WHITE_SPACE* BASH EOL*
  public static boolean task_image_run_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TASK_IMAGE_RUN_ITEM, "<task image run item>");
    r = task_image_run_item_0(b, l + 1);
    if (!r) r = task_image_run_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "container" WHITE_SPACE* COLON WHITE_SPACE* PLAIN_TEXT
  private static boolean task_image_run_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "container");
    r = r && task_image_run_item_0_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && task_image_run_item_0_3(b, l + 1);
    r = r && consumeToken(b, PLAIN_TEXT);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_image_run_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_run_item_0_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean task_image_run_item_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_run_item_0_3", c)) break;
    }
    return true;
  }

  // 'command' WHITE_SPACE* COLON WHITE_SPACE* BASH EOL*
  private static boolean task_image_run_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "command");
    r = r && task_image_run_item_1_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && task_image_run_item_1_3(b, l + 1);
    r = r && consumeToken(b, BASH);
    r = r && task_image_run_item_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_image_run_item_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_run_item_1_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean task_image_run_item_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_image_run_item_1_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean task_image_run_item_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_image_run_item_1_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "task_image_run_item_1_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // INDENT_LEVEL2 task-name WHITE_SPACE* COLON WHITE_SPACE* EOL task-property-list EOL*
  public static boolean task_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_list")) return false;
    if (!nextTokenIs(b, INDENT_LEVEL2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL2);
    r = r && task_name(b, l + 1);
    r = r && task_list_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && task_list_4(b, l + 1);
    r = r && consumeToken(b, EOL);
    r = r && task_property_list(b, l + 1);
    r = r && task_list_7(b, l + 1);
    exit_section_(b, m, TASK_LIST, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_list_2", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean task_list_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_list_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_list_4", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean task_list_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_list_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "task_list_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PLAIN_TEXT
  public static boolean task_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_name")) return false;
    if (!nextTokenIs(b, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAIN_TEXT);
    exit_section_(b, m, TASK_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT_LEVEL2 task-image-item WHITE_SPACE* EOL*
  public static boolean task_property_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_property_list")) return false;
    if (!nextTokenIs(b, INDENT_LEVEL2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT_LEVEL2);
    r = r && task_image_item(b, l + 1);
    r = r && task_property_list_2(b, l + 1);
    r = r && task_property_list_3(b, l + 1);
    exit_section_(b, m, TASK_PROPERTY_LIST, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean task_property_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_property_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "task_property_list_2", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean task_property_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "task_property_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "task_property_list_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // tasks-key WHITE_SPACE* COLON WHITE_SPACE* tasks-value EOL*
  public static boolean tasks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TASKS, "<tasks>");
    r = tasks_key(b, l + 1);
    r = r && tasks_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && tasks_3(b, l + 1);
    r = r && tasks_value(b, l + 1);
    r = r && tasks_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE*
  private static boolean tasks_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "tasks_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE*
  private static boolean tasks_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "tasks_3", c)) break;
    }
    return true;
  }

  // EOL*
  private static boolean tasks_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, EOL)) break;
      if (!empty_element_parsed_guard_(b, "tasks_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'tasks'
  public static boolean tasks_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TASKS_KEY, "<tasks key>");
    r = consumeToken(b, "tasks");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT | task-list
  public static boolean tasks_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tasks_value")) return false;
    if (!nextTokenIs(b, "<tasks value>", INDENT_LEVEL2, PLAIN_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TASKS_VALUE, "<tasks value>");
    r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = task_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
