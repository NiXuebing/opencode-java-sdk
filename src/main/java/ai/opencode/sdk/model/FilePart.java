package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param mime MIME 类型。
 * @param filename 文件名。
 * @param url 可访问的地址。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FilePart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("mime")
  private final String mime;
  @JsonProperty("filename")
  private final String filename;
  @JsonProperty("url")
  private final String url;
  @JsonProperty("source")
  private final FilePartSource source;

  /** 使用字段创建文件片段。 */
  @JsonCreator
  public FilePart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("mime") String mime,
      @JsonProperty("filename") String filename,
      @JsonProperty("url") String url,
      @JsonProperty("source") FilePartSource source
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.mime = mime;
    this.filename = filename;
    this.url = url;
    this.source = source;
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
   * 获取MIME。
   *
   * @return MIME 类型。
   */
  public String mime() {
    return mime;
  }

  /**
   * 获取filename。
   *
   * @return 文件名。
   */
  public String filename() {
    return filename;
  }

  /**
   * 获取地址。
   *
   * @return 可访问的地址。
   */
  public String url() {
    return url;
  }

  /**
   * 获取来源。
   *
   * @return 来源。
   */
  public FilePartSource source() {
    return source;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FilePart)) return false;
    FilePart that = (FilePart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(mime, that.mime)
        && Objects.equals(filename, that.filename)
        && Objects.equals(url, that.url)
        && Objects.equals(source, that.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, mime, filename, url, source);
  }

  @Override
  public String toString() {
    return "FilePart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "mime=" + mime + "," +
        "filename=" + filename + "," +
        "url=" + url + "," +
        "source=" + source +
        "}";
  }
}
