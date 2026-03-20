package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * TUI提示词追加事件属性。
 *
 * @param text 文本内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventTuiPromptAppendProperties {
  @JsonProperty("text")
  private final String text;

  /** 使用字段创建事件TUI提示词追加属性。 */
  @JsonCreator
  public EventTuiPromptAppendProperties(
      @JsonProperty("text") String text
  ) {
    this.text = text;
  }

  /**
   * 获取文本。
   *
   * @return 文本内容。
   */
  public String text() {
    return text;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventTuiPromptAppendProperties)) return false;
    EventTuiPromptAppendProperties that = (EventTuiPromptAppendProperties) other;
    return Objects.equals(text, that.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    return "EventTuiPromptAppendProperties{" +
        "text=" + text +
        "}";
  }
}
