package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 压缩片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param auto 是否自动执行。
 * @param overflow 溢出标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CompactionPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("auto")
  private final Boolean auto;
  @JsonProperty("overflow")
  private final Boolean overflow;

  /** 使用字段创建压缩片段。 */
  @JsonCreator
  public CompactionPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("auto") Boolean auto,
      @JsonProperty("overflow") Boolean overflow
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.auto = auto;
    this.overflow = overflow;
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
   * 获取自动。
   *
   * @return 是否自动执行。
   */
  public Boolean auto() {
    return auto;
  }

  /**
   * 获取溢出。
   *
   * @return 溢出标记。
   */
  public Boolean overflow() {
    return overflow;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof CompactionPart)) return false;
    CompactionPart that = (CompactionPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(auto, that.auto)
        && Objects.equals(overflow, that.overflow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, auto, overflow);
  }

  @Override
  public String toString() {
    return "CompactionPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "auto=" + auto + "," +
        "overflow=" + overflow +
        "}";
  }
}
