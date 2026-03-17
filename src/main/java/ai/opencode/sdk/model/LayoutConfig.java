package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LayoutConfig {
  AUTO("auto"),
  STRETCH("stretch");

  private final String value;

  LayoutConfig(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static LayoutConfig fromValue(String value) {
    for (LayoutConfig item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
