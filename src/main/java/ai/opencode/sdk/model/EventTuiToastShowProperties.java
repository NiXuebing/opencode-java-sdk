package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * TUI提示显示事件属性。
 *
 * @param title 标题。
 * @param message 消息内容。
 * @param variant 变体名称。
 * @param duration 持续时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventTuiToastShowProperties {
  @JsonProperty("title")
  private final String title;
  @JsonProperty("message")
  private final String message;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("duration")
  private final Double duration;

  /** 使用字段创建事件TUI提示显示属性。 */
  @JsonCreator
  public EventTuiToastShowProperties(
      @JsonProperty("title") String title,
      @JsonProperty("message") String message,
      @JsonProperty("variant") String variant,
      @JsonProperty("duration") Double duration
  ) {
    this.title = title;
    this.message = message;
    this.variant = variant;
    this.duration = duration;
  }

  /**
   * 获取title。
   *
   * @return 标题。
   */
  public String title() {
    return title;
  }

  /**
   * 获取消息。
   *
   * @return 消息内容。
   */
  public String message() {
    return message;
  }

  /**
   * 获取变体。
   *
   * @return 变体名称。
   */
  public String variant() {
    return variant;
  }

  /**
   * 获取duration。
   *
   * @return 持续时间。
   */
  public Double duration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventTuiToastShowProperties)) return false;
    EventTuiToastShowProperties that = (EventTuiToastShowProperties) other;
    return Objects.equals(title, that.title)
        && Objects.equals(message, that.message)
        && Objects.equals(variant, that.variant)
        && Objects.equals(duration, that.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, message, variant, duration);
  }

  @Override
  public String toString() {
    return "EventTuiToastShowProperties{" +
        "title=" + title + "," +
        "message=" + message + "," +
        "variant=" + variant + "," +
        "duration=" + duration +
        "}";
  }
}
