package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Step Finish片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param reason 原因说明。
 * @param snapshot 是否启用快照。
 * @param cost 成本。
 * @param tokens 令牌。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StepFinishPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("reason")
  private final String reason;
  @JsonProperty("snapshot")
  private final String snapshot;
  @JsonProperty("cost")
  private final Double cost;
  @JsonProperty("tokens")
  private final StepFinishPartTokens tokens;

  /** 使用字段创建Step Finish片段。 */
  @JsonCreator
  public StepFinishPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("reason") String reason,
      @JsonProperty("snapshot") String snapshot,
      @JsonProperty("cost") Double cost,
      @JsonProperty("tokens") StepFinishPartTokens tokens
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.reason = reason;
    this.snapshot = snapshot;
    this.cost = cost;
    this.tokens = tokens;
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
   * 获取reason。
   *
   * @return 原因说明。
   */
  public String reason() {
    return reason;
  }

  /**
   * 获取snapshot。
   *
   * @return 是否启用快照。
   */
  public String snapshot() {
    return snapshot;
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
  public StepFinishPartTokens tokens() {
    return tokens;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StepFinishPart)) return false;
    StepFinishPart that = (StepFinishPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(reason, that.reason)
        && Objects.equals(snapshot, that.snapshot)
        && Objects.equals(cost, that.cost)
        && Objects.equals(tokens, that.tokens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, reason, snapshot, cost, tokens);
  }

  @Override
  public String toString() {
    return "StepFinishPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "reason=" + reason + "," +
        "snapshot=" + snapshot + "," +
        "cost=" + cost + "," +
        "tokens=" + tokens +
        "}";
  }
}
