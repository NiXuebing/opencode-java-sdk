package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话Shell请求体。
 *
 * @param agent 代理名称。
 * @param model 模型配置。
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionShellBody {
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final SessionShellBodyModel model;
  @JsonProperty("command")
  private final String command;

  /** 使用字段创建会话Shell请求体。 */
  @JsonCreator
  public SessionShellBody(
      @JsonProperty("agent") String agent,
      @JsonProperty("model") SessionShellBodyModel model,
      @JsonProperty("command") String command
  ) {
    this.agent = agent;
    this.model = model;
    this.command = command;
  }

  /**
   * 获取代理。
   *
   * @return 代理名称。
   */
  public String agent() {
    return agent;
  }

  /**
   * 获取模型。
   *
   * @return 模型配置。
   */
  public SessionShellBodyModel model() {
    return model;
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
    if (!(other instanceof SessionShellBody)) return false;
    SessionShellBody that = (SessionShellBody) other;
    return Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(command, that.command);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agent, model, command);
  }

  @Override
  public String toString() {
    return "SessionShellBody{" +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "command=" + command +
        "}";
  }
}
