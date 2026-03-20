package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

/**
 * 助手消息数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param role 消息角色。
 * @param time 时间。
 * @param error 错误信息。
 * @param parentID 父级消息 ID。
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 * @param mode 运行模式。
 * @param agent 代理名称。
 * @param path 目标文件或目录路径。
 * @param summary 是否为摘要内容。
 * @param cost 成本。
 * @param tokens 令牌。
 * @param structured 结构化输出内容。
 * @param variant 变体名称。
 * @param finish 结束原因。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AssistantMessage implements Message {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("role")
  private final String role;
  @JsonProperty("time")
  private final AssistantMessageTime time;
  @JsonProperty("error")
  private final AssistantMessageError error;
  @JsonProperty("parentID")
  private final String parentID;
  @JsonProperty("modelID")
  private final String modelID;
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("mode")
  private final String mode;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("path")
  private final AssistantMessagePath path;
  @JsonProperty("summary")
  private final Boolean summary;
  @JsonProperty("cost")
  private final Double cost;
  @JsonProperty("tokens")
  private final AssistantMessageTokens tokens;
  @JsonProperty("structured")
  private final JsonNode structured;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("finish")
  private final String finish;

  /** 使用字段创建助手消息。 */
  @JsonCreator
  public AssistantMessage(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("role") String role,
      @JsonProperty("time") AssistantMessageTime time,
      @JsonProperty("error") AssistantMessageError error,
      @JsonProperty("parentID") String parentID,
      @JsonProperty("modelID") String modelID,
      @JsonProperty("providerID") String providerID,
      @JsonProperty("mode") String mode,
      @JsonProperty("agent") String agent,
      @JsonProperty("path") AssistantMessagePath path,
      @JsonProperty("summary") Boolean summary,
      @JsonProperty("cost") Double cost,
      @JsonProperty("tokens") AssistantMessageTokens tokens,
      @JsonProperty("structured") JsonNode structured,
      @JsonProperty("variant") String variant,
      @JsonProperty("finish") String finish
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.role = role;
    this.time = time;
    this.error = error;
    this.parentID = parentID;
    this.modelID = modelID;
    this.providerID = providerID;
    this.mode = mode;
    this.agent = agent;
    this.path = path;
    this.summary = summary;
    this.cost = cost;
    this.tokens = tokens;
    this.structured = structured;
    this.variant = variant;
    this.finish = finish;
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
  public AssistantMessageTime time() {
    return time;
  }

  /**
   * 获取错误。
   *
   * @return 错误信息。
   */
  public AssistantMessageError error() {
    return error;
  }

  /**
   * 获取parent ID。
   *
   * @return 父级消息 ID。
   */
  public String parentID() {
    return parentID;
  }

  /**
   * 获取模型ID。
   *
   * @return 模型 ID。
   */
  public String modelID() {
    return modelID;
  }

  /**
   * 获取提供商ID。
   *
   * @return 目标提供商 ID。
   */
  public String providerID() {
    return providerID;
  }

  /**
   * 获取模式。
   *
   * @return 运行模式。
   */
  public String mode() {
    return mode;
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
   * 获取路径。
   *
   * @return 目标文件或目录路径。
   */
  public AssistantMessagePath path() {
    return path;
  }

  /**
   * 获取摘要。
   *
   * @return 是否为摘要内容。
   */
  public Boolean summary() {
    return summary;
  }

  /**
   * 获取成本。
   *
   * @return 成本。
   */
  public Double cost() {
    return cost;
  }

  /**
   * 获取令牌。
   *
   * @return 令牌。
   */
  public AssistantMessageTokens tokens() {
    return tokens;
  }

  /**
   * 获取结构化。
   *
   * @return 结构化输出内容。
   */
  public JsonNode structured() {
    return structured;
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
   * 获取finish。
   *
   * @return 结束原因。
   */
  public String finish() {
    return finish;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AssistantMessage)) return false;
    AssistantMessage that = (AssistantMessage) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(role, that.role)
        && Objects.equals(time, that.time)
        && Objects.equals(error, that.error)
        && Objects.equals(parentID, that.parentID)
        && Objects.equals(modelID, that.modelID)
        && Objects.equals(providerID, that.providerID)
        && Objects.equals(mode, that.mode)
        && Objects.equals(agent, that.agent)
        && Objects.equals(path, that.path)
        && Objects.equals(summary, that.summary)
        && Objects.equals(cost, that.cost)
        && Objects.equals(tokens, that.tokens)
        && Objects.equals(structured, that.structured)
        && Objects.equals(variant, that.variant)
        && Objects.equals(finish, that.finish);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, role, time, error, parentID, modelID, providerID, mode, agent, path, summary, cost, tokens, structured, variant, finish);
  }

  @Override
  public String toString() {
    return "AssistantMessage{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "role=" + role + "," +
        "time=" + time + "," +
        "error=" + error + "," +
        "parentID=" + parentID + "," +
        "modelID=" + modelID + "," +
        "providerID=" + providerID + "," +
        "mode=" + mode + "," +
        "agent=" + agent + "," +
        "path=" + path + "," +
        "summary=" + summary + "," +
        "cost=" + cost + "," +
        "tokens=" + tokens + "," +
        "structured=" + structured + "," +
        "variant=" + variant + "," +
        "finish=" + finish +
        "}";
  }
}
