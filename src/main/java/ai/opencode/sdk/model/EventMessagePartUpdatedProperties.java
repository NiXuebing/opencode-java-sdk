package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息片段已更新事件属性。
 *
 * @param part 片段。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMessagePartUpdatedProperties {
  @JsonProperty("part")
  private final Part part;

  /** 使用字段创建事件消息片段已更新属性。 */
  @JsonCreator
  public EventMessagePartUpdatedProperties(
      @JsonProperty("part") Part part
  ) {
    this.part = part;
  }

  /**
   * 获取片段。
   *
   * @return 片段。
   */
  public Part part() {
    return part;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMessagePartUpdatedProperties)) return false;
    EventMessagePartUpdatedProperties that = (EventMessagePartUpdatedProperties) other;
    return Objects.equals(part, that.part);
  }

  @Override
  public int hashCode() {
    return Objects.hash(part);
  }

  @Override
  public String toString() {
    return "EventMessagePartUpdatedProperties{" +
        "part=" + part +
        "}";
  }
}
