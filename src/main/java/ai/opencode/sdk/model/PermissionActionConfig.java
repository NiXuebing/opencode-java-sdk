package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

public enum PermissionActionConfig {
  ASK("ask"),
  ALLOW("allow"),
  DENY("deny");

  private final String value;

  PermissionActionConfig(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static PermissionActionConfig fromValue(String value) {
    for (PermissionActionConfig item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
