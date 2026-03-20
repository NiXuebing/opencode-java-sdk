package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件内容数据模型。
 *
 * @param type 类型标识。
 * @param content 正文内容。
 * @param diff 差异。
 * @param patch 补丁。
 * @param encoding 内容编码。
 * @param mimeType MIME 类型。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileContent {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("content")
  private final String content;
  @JsonProperty("diff")
  private final String diff;
  @JsonProperty("patch")
  private final FileContentPatch patch;
  @JsonProperty("encoding")
  private final String encoding;
  @JsonProperty("mimeType")
  private final String mimeType;

  /** 使用字段创建文件内容。 */
  @JsonCreator
  public FileContent(
      @JsonProperty("type") String type,
      @JsonProperty("content") String content,
      @JsonProperty("diff") String diff,
      @JsonProperty("patch") FileContentPatch patch,
      @JsonProperty("encoding") String encoding,
      @JsonProperty("mimeType") String mimeType
  ) {
    this.type = type;
    this.content = content;
    this.diff = diff;
    this.patch = patch;
    this.encoding = encoding;
    this.mimeType = mimeType;
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
   * 获取内容。
   *
   * @return 正文内容。
   */
  public String content() {
    return content;
  }

  /**
   * 获取差异。
   *
   * @return 差异。
   */
  public String diff() {
    return diff;
  }

  /**
   * 获取补丁。
   *
   * @return 补丁。
   */
  public FileContentPatch patch() {
    return patch;
  }

  /**
   * 获取encoding。
   *
   * @return 内容编码。
   */
  public String encoding() {
    return encoding;
  }

  /**
   * 获取MIME类型。
   *
   * @return MIME 类型。
   */
  public String mimeType() {
    return mimeType;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileContent)) return false;
    FileContent that = (FileContent) other;
    return Objects.equals(type, that.type)
        && Objects.equals(content, that.content)
        && Objects.equals(diff, that.diff)
        && Objects.equals(patch, that.patch)
        && Objects.equals(encoding, that.encoding)
        && Objects.equals(mimeType, that.mimeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, content, diff, patch, encoding, mimeType);
  }

  @Override
  public String toString() {
    return "FileContent{" +
        "type=" + type + "," +
        "content=" + content + "," +
        "diff=" + diff + "," +
        "patch=" + patch + "," +
        "encoding=" + encoding + "," +
        "mimeType=" + mimeType +
        "}";
  }
}
