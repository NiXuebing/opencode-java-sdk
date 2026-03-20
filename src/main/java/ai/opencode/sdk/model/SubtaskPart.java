package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 子任务片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param prompt 提示词。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型配置。
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SubtaskPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("prompt")
  private final String prompt;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final SubtaskPartModel model;
  @JsonProperty("command")
  private final String command;

  /** 使用字段创建子任务片段。 */
  @JsonCreator
  public SubtaskPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("prompt") String prompt,
      @JsonProperty("description") String description,
      @JsonProperty("agent") String agent,
      @JsonProperty("model") SubtaskPartModel model,
      @JsonProperty("command") String command
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.prompt = prompt;
    this.description = description;
    this.agent = agent;
    this.model = model;
    this.command = command;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取会话ID。
   *
   * @return 目标会话 ID。
   */
  public String sessionID() {
    return sessionID;
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
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取提示词。
   *
   * @return 提示词。
   */
  public String prompt() {
    return prompt;
  }

  /**
   * 获取description。
   *
   * @return 描述信息。
   */
  public String description() {
    return description;
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
  public SubtaskPartModel model() {
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
    if (!(other instanceof SubtaskPart)) return false;
    SubtaskPart that = (SubtaskPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(prompt, that.prompt)
        && Objects.equals(description, that.description)
        && Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(command, that.command);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, prompt, description, agent, model, command);
  }

  @Override
  public String toString() {
    return "SubtaskPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "prompt=" + prompt + "," +
        "description=" + description + "," +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "command=" + command +
        "}";
  }
}
