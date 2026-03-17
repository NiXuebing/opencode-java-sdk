package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** 权限Action枚举。 */
public enum PermissionAction {
  ALLOW("allow"),
  DENY("deny"),
  ASK("ask");

  private final String value;

  PermissionAction(String value) {
    this.value = value;
  }

  /**
   * 获取枚举对应的原始值。
   *
   * @return 原始值。
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * 根据原始值解析枚举。
   *
   * @param value 原始值。
   * @return 对应的 PermissionAction 枚举值。
   */
  @JsonCreator
  public static PermissionAction fromValue(String value) {
    for (PermissionAction item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
