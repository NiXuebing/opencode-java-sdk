package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 会话提示词异步请求体。
 *
 * @param messageID 目标消息 ID。
 * @param model 模型配置。
 * @param agent 代理名称。
 * @param noReply 是否不等待助手回复。
 * @param tools 工具开关配置。
 * @param format 输出格式配置。
 * @param system 系统提示词。
 * @param variant 变体名称。
 * @param parts 片段列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionPromptAsyncBody {
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("model")
  private final SessionPromptAsyncBodyModel model;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("noReply")
  private final Boolean noReply;
  @JsonProperty("tools")
  private final Map<String, Boolean> tools;
  @JsonProperty("format")
  private final OutputFormat format;
  @JsonProperty("system")
  private final String system;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("parts")
  private final List<SessionPromptAsyncBodyPartsItem> parts;

  /** 使用字段创建会话提示词异步请求体。 */
  @JsonCreator
  public SessionPromptAsyncBody(
      @JsonProperty("messageID") String messageID,
      @JsonProperty("model") SessionPromptAsyncBodyModel model,
      @JsonProperty("agent") String agent,
      @JsonProperty("noReply") Boolean noReply,
      @JsonProperty("tools") Map<String, Boolean> tools,
      @JsonProperty("format") OutputFormat format,
      @JsonProperty("system") String system,
      @JsonProperty("variant") String variant,
      @JsonProperty("parts") List<SessionPromptAsyncBodyPartsItem> parts
  ) {
    this.messageID = messageID;
    this.model = model;
    this.agent = agent;
    this.noReply = noReply;
    this.tools = tools;
    this.format = format;
    this.system = system;
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
   * 获取模型。
   *
   * @return 模型配置。
   */
  public SessionPromptAsyncBodyModel model() {
    return model;
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
   * 获取no回复。
   *
   * @return 是否不等待助手回复。
   */
  public Boolean noReply() {
    return noReply;
  }

  /**
   * 获取工具。
   *
   * @return 工具开关配置。
   */
  public Map<String, Boolean> tools() {
    return tools;
  }

  /**
   * 获取格式。
   *
   * @return 输出格式配置。
   */
  public OutputFormat format() {
    return format;
  }

  /**
   * 获取system。
   *
   * @return 系统提示词。
   */
  public String system() {
    return system;
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
  public List<SessionPromptAsyncBodyPartsItem> parts() {
    return parts;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionPromptAsyncBody)) return false;
    SessionPromptAsyncBody that = (SessionPromptAsyncBody) other;
    return Objects.equals(messageID, that.messageID)
        && Objects.equals(model, that.model)
        && Objects.equals(agent, that.agent)
        && Objects.equals(noReply, that.noReply)
        && Objects.equals(tools, that.tools)
        && Objects.equals(format, that.format)
        && Objects.equals(system, that.system)
        && Objects.equals(variant, that.variant)
        && Objects.equals(parts, that.parts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID, model, agent, noReply, tools, format, system, variant, parts);
  }

  @Override
  public String toString() {
    return "SessionPromptAsyncBody{" +
        "messageID=" + messageID + "," +
        "model=" + model + "," +
        "agent=" + agent + "," +
        "noReply=" + noReply + "," +
        "tools=" + tools + "," +
        "format=" + format + "," +
        "system=" + system + "," +
        "variant=" + variant + "," +
        "parts=" + parts +
        "}";
  }
}
