package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件Node数据模型。
 *
 * @param name 名称。
 * @param path 目标文件或目录路径。
 * @param absolute 绝对。
 * @param type 类型标识。
 * @param ignored 是否忽略。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileNode {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("path")
  private final String path;
  @JsonProperty("absolute")
  private final String absolute;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("ignored")
  private final Boolean ignored;

  /** 使用字段创建文件Node。 */
  @JsonCreator
  public FileNode(
      @JsonProperty("name") String name,
      @JsonProperty("path") String path,
      @JsonProperty("absolute") String absolute,
      @JsonProperty("type") String type,
      @JsonProperty("ignored") Boolean ignored
  ) {
    this.name = name;
    this.path = path;
    this.absolute = absolute;
    this.type = type;
    this.ignored = ignored;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  /**
   * 获取路径。
   *
   * @return 目标文件或目录路径。
   */
  public String path() {
    return path;
  }

  /**
   * 获取绝对。
   *
   * @return 绝对。
   */
  public String absolute() {
    return absolute;
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
   * 获取已忽略。
   *
   * @return 是否忽略。
   */
  public Boolean ignored() {
    return ignored;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileNode)) return false;
    FileNode that = (FileNode) other;
    return Objects.equals(name, that.name)
        && Objects.equals(path, that.path)
        && Objects.equals(absolute, that.absolute)
        && Objects.equals(type, that.type)
        && Objects.equals(ignored, that.ignored);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, path, absolute, type, ignored);
  }

  @Override
  public String toString() {
    return "FileNode{" +
        "name=" + name + "," +
        "path=" + path + "," +
        "absolute=" + absolute + "," +
        "type=" + type + "," +
        "ignored=" + ignored +
        "}";
  }
}
