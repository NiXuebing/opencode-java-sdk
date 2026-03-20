package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 推理片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param text 文本内容。
 * @param metadata 元数据映射。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ReasoningPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("text")
  private final String text;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;
  @JsonProperty("time")
  private final ReasoningPartTime time;

  /** 使用字段创建推理片段。 */
  @JsonCreator
  public ReasoningPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("text") String text,
      @JsonProperty("metadata") Map<String, JsonNode> metadata,
      @JsonProperty("time") ReasoningPartTime time
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.text = text;
    this.metadata = metadata;
    this.time = time;
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
   * 获取文本。
   *
   * @return 文本内容。
   */
  public String text() {
    return text;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, JsonNode> metadata() {
    return metadata;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public ReasoningPartTime time() {
    return time;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ReasoningPart)) return false;
    ReasoningPart that = (ReasoningPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(text, that.text)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, text, metadata, time);
  }

  @Override
  public String toString() {
    return "ReasoningPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "text=" + text + "," +
        "metadata=" + metadata + "," +
        "time=" + time +
        "}";
  }
}
