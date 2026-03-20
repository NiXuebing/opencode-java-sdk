package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 会话命令请求体。
 *
 * @param messageID 目标消息 ID。
 * @param agent 代理名称。
 * @param model 模型 ID 或名称。
 * @param arguments 参数内容。
 * @param command 命令内容。
 * @param variant 变体名称。
 * @param parts 片段列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionCommandBody {
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final String model;
  @JsonProperty("arguments")
  private final String arguments;
  @JsonProperty("command")
  private final String command;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("parts")
  private final List<SessionCommandBodyPartsItem> parts;

  /** 使用字段创建会话命令请求体。 */
  @JsonCreator
  public SessionCommandBody(
      @JsonProperty("messageID") String messageID,
      @JsonProperty("agent") String agent,
      @JsonProperty("model") String model,
      @JsonProperty("arguments") String arguments,
      @JsonProperty("command") String command,
      @JsonProperty("variant") String variant,
      @JsonProperty("parts") List<SessionCommandBodyPartsItem> parts
  ) {
    this.messageID = messageID;
    this.agent = agent;
    this.model = model;
    this.arguments = arguments;
    this.command = command;
    this.variant = variant;
    this.parts = parts;
  }

  /**
   * 获取消息ID。
   *
   * @return 目标消息 ID。
   */
  public String messageID() {
    return messageID;
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
   * @return 模型 ID 或名称。
   */
  public String model() {
    return model;
  }

  /**
   * 获取arguments。
   *
   * @return 参数内容。
   */
  public String arguments() {
    return arguments;
  }

  /**
   * 获取命令。
   *
   * @return 命令内容。
   */
  public String command() {
    return command;
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
   * 获取片段。
   *
   * @return 片段列表。
   */
  public List<SessionCommandBodyPartsItem> parts() {
    return parts;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionCommandBody)) return false;
    SessionCommandBody that = (SessionCommandBody) other;
    return Objects.equals(messageID, that.messageID)
        && Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(arguments, that.arguments)
        && Objects.equals(command, that.command)
        && Objects.equals(variant, that.variant)
        && Objects.equals(parts, that.parts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID, agent, model, arguments, command, variant, parts);
  }

  @Override
  public String toString() {
    return "SessionCommandBody{" +
        "messageID=" + messageID + "," +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "arguments=" + arguments + "," +
        "command=" + command + "," +
        "variant=" + variant + "," +
        "parts=" + parts +
        "}";
  }
}
