package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 补丁片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param hash hash。
 * @param files 文件列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PatchPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("hash")
  private final String hash;
  @JsonProperty("files")
  private final List<String> files;

  /** 使用字段创建补丁片段。 */
  @JsonCreator
  public PatchPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("hash") String hash,
      @JsonProperty("files") List<String> files
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.hash = hash;
    this.files = files;
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
   * 获取hash。
   *
   * @return hash。
   */
  public String hash() {
    return hash;
  }

  /**
   * 获取文件。
   *
   * @return 文件列表。
   */
  public List<String> files() {
    return files;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PatchPart)) return false;
    PatchPart that = (PatchPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(hash, that.hash)
        && Objects.equals(files, that.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, hash, files);
  }

  @Override
  public String toString() {
    return "PatchPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "hash=" + hash + "," +
        "files=" + files +
        "}";
  }
}
