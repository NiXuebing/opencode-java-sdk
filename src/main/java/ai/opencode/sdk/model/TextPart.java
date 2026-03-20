package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 文本片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param text 文本内容。
 * @param synthetic 合成标记。
 * @param ignored 是否忽略。
 * @param time 时间。
 * @param metadata 元数据映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TextPart implements Part {
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
  @JsonProperty("synthetic")
  private final Boolean synthetic;
  @JsonProperty("ignored")
  private final Boolean ignored;
  @JsonProperty("time")
  private final TextPartTime time;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;

  /** 使用字段创建文本片段。 */
  @JsonCreator
  public TextPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("text") String text,
      @JsonProperty("synthetic") Boolean synthetic,
      @JsonProperty("ignored") Boolean ignored,
      @JsonProperty("time") TextPartTime time,
      @JsonProperty("metadata") Map<String, JsonNode> metadata
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.text = text;
    this.synthetic = synthetic;
    this.ignored = ignored;
    this.time = time;
    this.metadata = metadata;
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
   * 获取合成。
   *
   * @return 合成标记。
   */
  public Boolean synthetic() {
    return synthetic;
  }

  /**
   * 获取已忽略。
   *
   * @return 是否忽略。
   */
  public Boolean ignored() {
    return ignored;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public TextPartTime time() {
    return time;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, JsonNode> metadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof TextPart)) return false;
    TextPart that = (TextPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(text, that.text)
        && Objects.equals(synthetic, that.synthetic)
        && Objects.equals(ignored, that.ignored)
        && Objects.equals(time, that.time)
        && Objects.equals(metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, text, synthetic, ignored, time, metadata);
  }

  @Override
  public String toString() {
    return "TextPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "text=" + text + "," +
        "synthetic=" + synthetic + "," +
        "ignored=" + ignored + "," +
        "time=" + time + "," +
        "metadata=" + metadata +
        "}";
  }
}
