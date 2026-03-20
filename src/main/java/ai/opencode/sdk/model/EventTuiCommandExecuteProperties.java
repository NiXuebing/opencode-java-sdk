package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * TUI命令执行事件属性。
 *
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventTuiCommandExecuteProperties {
  @JsonProperty("command")
  private final String command;

  /** 使用字段创建事件TUI命令执行属性。 */
  @JsonCreator
  public EventTuiCommandExecuteProperties(
      @JsonProperty("command") String command
  ) {
    this.command = command;
  }

  /**
   * 获取命令。
   *
   * @return 命令内容。
   */
  public String command() {
    return command;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventTuiCommandExecuteProperties)) return false;
    EventTuiCommandExecuteProperties that = (EventTuiCommandExecuteProperties) other;
    return Objects.equals(command, that.command);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command);
  }

  @Override
  public String toString() {
    return "EventTuiCommandExecuteProperties{" +
        "command=" + command +
        "}";
  }
}
