package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件来源数据模型。
 *
 * @param text 文本内容。
 * @param type 类型标识。
 * @param path 目标文件或目录路径。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileSource implements FilePartSource {
  @JsonProperty("text")
  private final FilePartSourceText text;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("path")
  private final String path;

  /** 使用字段创建文件来源。 */
  @JsonCreator
  public FileSource(
      @JsonProperty("text") FilePartSourceText text,
      @JsonProperty("type") String type,
      @JsonProperty("path") String path
  ) {
    this.text = text;
    this.type = type;
    this.path = path;
  }

  /**
   * 获取文本。
   *
   * @return 文本内容。
   */
  public FilePartSourceText text() {
    return text;
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
   * 获取路径。
   *
   * @return 目标文件或目录路径。
   */
  public String path() {
    return path;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileSource)) return false;
    FileSource that = (FileSource) other;
    return Objects.equals(text, that.text)
        && Objects.equals(type, that.type)
        && Objects.equals(path, that.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, type, path);
  }

  @Override
  public String toString() {
    return "FileSource{" +
        "text=" + text + "," +
        "type=" + type + "," +
        "path=" + path +
        "}";
  }
}
