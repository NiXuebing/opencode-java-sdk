package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话撤回数据模型。
 *
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 * @param snapshot 是否启用快照。
 * @param diff 差异。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionRevert {
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("partID")
  private final String partID;
  @JsonProperty("snapshot")
  private final String snapshot;
  @JsonProperty("diff")
  private final String diff;

  /** 使用字段创建会话撤回。 */
  @JsonCreator
  public SessionRevert(
      @JsonProperty("messageID") String messageID,
      @JsonProperty("partID") String partID,
      @JsonProperty("snapshot") String snapshot,
      @JsonProperty("diff") String diff
  ) {
    this.messageID = messageID;
    this.partID = partID;
    this.snapshot = snapshot;
    this.diff = diff;
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
   * 获取片段ID。
   *
   * @return 片段 ID。
   */
  public String partID() {
    return partID;
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
   * 获取差异。
   *
   * @return 差异。
   */
  public String diff() {
    return diff;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionRevert)) return false;
    SessionRevert that = (SessionRevert) other;
    return Objects.equals(messageID, that.messageID)
        && Objects.equals(partID, that.partID)
        && Objects.equals(snapshot, that.snapshot)
        && Objects.equals(diff, that.diff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID, partID, snapshot, diff);
  }

  @Override
  public String toString() {
    return "SessionRevert{" +
        "messageID=" + messageID + "," +
        "partID=" + partID + "," +
        "snapshot=" + snapshot + "," +
        "diff=" + diff +
        "}";
  }
}
