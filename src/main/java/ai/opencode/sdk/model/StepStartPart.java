package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Step Start片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param snapshot 是否启用快照。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StepStartPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("snapshot")
  private final String snapshot;

  /** 使用字段创建Step Start片段。 */
  @JsonCreator
  public StepStartPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("snapshot") String snapshot
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.snapshot = snapshot;
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
   * 获取snapshot。
   *
   * @return 是否启用快照。
   */
  public String snapshot() {
    return snapshot;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StepStartPart)) return false;
    StepStartPart that = (StepStartPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(snapshot, that.snapshot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, snapshot);
  }

  @Override
  public String toString() {
    return "StepStartPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "snapshot=" + snapshot +
        "}";
  }
}
