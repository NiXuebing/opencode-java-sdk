package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * PTY已创建事件属性。
 *
 * @param info 元信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventPtyCreatedProperties {
  @JsonProperty("info")
  private final Pty info;

  /** 使用字段创建事件PTY已创建属性。 */
  @JsonCreator
  public EventPtyCreatedProperties(
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
    if (!(other instanceof EventPtyCreatedProperties)) return false;
    EventPtyCreatedProperties that = (EventPtyCreatedProperties) other;
    return Objects.equals(info, that.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info);
  }

  @Override
  public String toString() {
    return "EventPtyCreatedProperties{" +
        "info=" + info +
        "}";
  }
}
