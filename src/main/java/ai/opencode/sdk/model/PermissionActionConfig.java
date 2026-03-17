package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** 权限Action配置枚举。 */
public enum PermissionActionConfig {
  ASK("ask"),
  ALLOW("allow"),
  DENY("deny");

  private final String value;

  PermissionActionConfig(String value) {
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
   * @return 对应的 PermissionActionConfig 枚举值。
   */
  @JsonCreator
  public static PermissionActionConfig fromValue(String value) {
    for (PermissionActionConfig item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
