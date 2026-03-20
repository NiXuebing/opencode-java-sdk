package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param mime MIME 类型。
 * @param filename 文件名。
 * @param url 可访问的地址。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FilePartInput implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {
  @JsonProperty("id")
  private final String id;
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

  /** 使用字段创建文件片段输入。 */
  @JsonCreator
  public FilePartInput(
      @JsonProperty("id") String id,
      @JsonProperty("type") String type,
      @JsonProperty("mime") String mime,
      @JsonProperty("filename") String filename,
      @JsonProperty("url") String url,
      @JsonProperty("source") FilePartSource source
  ) {
    this.id = id;
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
    if (!(other instanceof FilePartInput)) return false;
    FilePartInput that = (FilePartInput) other;
    return Objects.equals(id, that.id)
        && Objects.equals(type, that.type)
        && Objects.equals(mime, that.mime)
        && Objects.equals(filename, that.filename)
        && Objects.equals(url, that.url)
        && Objects.equals(source, that.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, mime, filename, url, source);
  }

  @Override
  public String toString() {
    return "FilePartInput{" +
        "id=" + id + "," +
        "type=" + type + "," +
        "mime=" + mime + "," +
        "filename=" + filename + "," +
        "url=" + url + "," +
        "source=" + source +
        "}";
  }
}
