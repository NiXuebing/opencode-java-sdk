package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PermissionAction {
  ALLOW("allow"),
  DENY("deny"),
  ASK("ask");

  private final String value;

  PermissionAction(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static PermissionAction fromValue(String value) {
    for (PermissionAction item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
