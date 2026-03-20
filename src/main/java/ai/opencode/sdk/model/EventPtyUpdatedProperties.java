package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * PTY已更新事件属性。
 *
 * @param info 元信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventPtyUpdatedProperties {
  @JsonProperty("info")
  private final Pty info;

  /** 使用字段创建事件PTY已更新属性。 */
  @JsonCreator
  public EventPtyUpdatedProperties(
      @JsonProperty("info") Pty info
  ) {
    this.info = info;
  }

  /**
   * 获取信息。
   *
   * @return 元信息。
   */
  public Pty info() {
    return info;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventPtyUpdatedProperties)) return false;
    EventPtyUpdatedProperties that = (EventPtyUpdatedProperties) other;
    return Objects.equals(info, that.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }

  @Override
  public String toString() {
    return "EventPtyUpdatedProperties{" +
        "info=" + info +
        "}";
  }
}
