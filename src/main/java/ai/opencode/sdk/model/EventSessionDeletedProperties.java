package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话已删除事件属性。
 *
 * @param info 元信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventSessionDeletedProperties {
  @JsonProperty("info")
  private final Session info;

  /** 使用字段创建事件会话已删除属性。 */
  @JsonCreator
  public EventSessionDeletedProperties(
      @JsonProperty("info") Session info
  ) {
    this.info = info;
  }

  /**
   * 获取信息。
   *
   * @return 元信息。
   */
  public Session info() {
    return info;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventSessionDeletedProperties)) return false;
    EventSessionDeletedProperties that = (EventSessionDeletedProperties) other;
    return Objects.equals(info, that.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }

  @Override
  public String toString() {
    return "EventSessionDeletedProperties{" +
        "info=" + info +
        "}";
  }
}
