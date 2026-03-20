package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * 用户消息数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param role 消息角色。
 * @param time 时间。
 * @param format 输出格式配置。
 * @param summary 摘要内容。
 * @param agent 代理名称。
 * @param model 模型配置。
 * @param system 系统提示词。
 * @param tools 工具开关配置。
 * @param variant 变体名称。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UserMessage implements Message {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("role")
  private final String role;
  @JsonProperty("time")
  private final UserMessageTime time;
  @JsonProperty("format")
  private final OutputFormat format;
  @JsonProperty("summary")
  private final UserMessageSummary summary;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final UserMessageModel model;
  @JsonProperty("system")
  private final String system;
  @JsonProperty("tools")
  private final Map<String, Boolean> tools;
  @JsonProperty("variant")
  private final String variant;

  /** 使用字段创建用户消息。 */
  @JsonCreator
  public UserMessage(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("role") String role,
      @JsonProperty("time") UserMessageTime time,
      @JsonProperty("format") OutputFormat format,
      @JsonProperty("summary") UserMessageSummary summary,
      @JsonProperty("agent") String agent,
      @JsonProperty("model") UserMessageModel model,
      @JsonProperty("system") String system,
      @JsonProperty("tools") Map<String, Boolean> tools,
      @JsonProperty("variant") String variant
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.role = role;
    this.time = time;
    this.format = format;
    this.summary = summary;
    this.agent = agent;
    this.model = model;
    this.system = system;
    this.tools = tools;
    this.variant = variant;
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
   * 获取角色。
   *
   * @return 消息角色。
   */
  public String role() {
    return role;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public UserMessageTime time() {
    return time;
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
   * 获取摘要。
   *
   * @return 摘要内容。
   */
  public UserMessageSummary summary() {
    return summary;
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
  public UserMessageModel model() {
    return model;
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
   * 获取工具。
   *
   * @return 工具开关配置。
   */
  public Map<String, Boolean> tools() {
    return tools;
  }

  /**
   * 获取变体。
   *
   * @return 变体名称。
   */
  public String variant() {
    return variant;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof UserMessage)) return false;
    UserMessage that = (UserMessage) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(role, that.role)
        && Objects.equals(time, that.time)
        && Objects.equals(format, that.format)
        && Objects.equals(summary, that.summary)
        && Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(system, that.system)
        && Objects.equals(tools, that.tools)
        && Objects.equals(variant, that.variant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, role, time, format, summary, agent, model, system, tools, variant);
  }

  @Override
  public String toString() {
    return "UserMessage{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "role=" + role + "," +
        "time=" + time + "," +
        "format=" + format + "," +
        "summary=" + summary + "," +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "system=" + system + "," +
        "tools=" + tools + "," +
        "variant=" + variant +
        "}";
  }
}
