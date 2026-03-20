package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

/**
 * 权限配置值对象。
 *
 * @param value 实际值。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionConfig {
  private final JsonNode value;

  /**
   * 使用实际值创建对象。
   *
   * @param value 实际值。
   */
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public PermissionConfig(JsonNode value) {
    this.value = value;
  }

  /**
   * 获取实际值。
   *
   * @return 实际值。
   */
  @JsonValue
  public JsonNode value() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionConfig)) return false;
    PermissionConfig that = (PermissionConfig) other;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "PermissionConfig{" + "value=" + value + "}";
  }
}
