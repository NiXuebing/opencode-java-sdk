package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** 日志Level枚举。 */
public enum LogLevel {
  DEBUG("DEBUG"),
  INFO("INFO"),
  WARN("WARN"),
  ERROR("ERROR");

  private final String value;

  LogLevel(String value) {
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
   * @return 对应的 LogLevel 枚举值。
   */
  @JsonCreator
  public static LogLevel fromValue(String value) {
    for (LogLevel item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
