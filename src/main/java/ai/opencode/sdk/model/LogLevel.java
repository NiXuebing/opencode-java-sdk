package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LogLevel {
  DEBUG("DEBUG"),
  INFO("INFO"),
  WARN("WARN"),
  ERROR("ERROR");

  private final String value;

  LogLevel(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static LogLevel fromValue(String value) {
    for (LogLevel item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
