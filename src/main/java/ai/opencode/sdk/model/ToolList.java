package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.List;
import java.util.Objects;

/**
 * 工具列表值对象。
 *
 * @param value 实际值。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolList {
  private final List<ToolListItem> value;

  /**
   * 使用实际值创建对象。
   *
   * @param value 实际值。
   */
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ToolList(List<ToolListItem> value) {
    this.value = value;
  }

  /**
   * 获取实际值。
   *
   * @return 实际值。
   */
  @JsonValue
  public List<ToolListItem> value() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolList)) return false;
    ToolList that = (ToolList) other;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "ToolList{" + "value=" + value + "}";
  }
}
