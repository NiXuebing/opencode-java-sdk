package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息已更新事件属性。
 *
 * @param info 元信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMessageUpdatedProperties {
  @JsonProperty("info")
  private final Message info;

  /** 使用字段创建事件消息已更新属性。 */
  @JsonCreator
  public EventMessageUpdatedProperties(
      @JsonProperty("info") Message info
  ) {
    this.info = info;
  }

  /**
   * 获取信息。
   *
   * @return 元信息。
   */
  public Message info() {
    return info;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMessageUpdatedProperties)) return false;
    EventMessageUpdatedProperties that = (EventMessageUpdatedProperties) other;
    return Objects.equals(info, that.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }

  @Override
  public String toString() {
    return "EventMessageUpdatedProperties{" +
        "info=" + info +
        "}";
  }
}
