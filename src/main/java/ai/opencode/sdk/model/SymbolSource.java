package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 符号来源数据模型。
 *
 * @param text 文本内容。
 * @param type 类型标识。
 * @param path 目标文件或目录路径。
 * @param range 范围信息。
 * @param name 名称。
 * @param kind 类型值。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SymbolSource implements FilePartSource {
  @JsonProperty("text")
  private final FilePartSourceText text;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("path")
  private final String path;
  @JsonProperty("range")
  private final Range range;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("kind")
  private final Long kind;

  /** 使用字段创建符号来源。 */
  @JsonCreator
  public SymbolSource(
      @JsonProperty("text") FilePartSourceText text,
      @JsonProperty("type") String type,
      @JsonProperty("path") String path,
      @JsonProperty("range") Range range,
      @JsonProperty("name") String name,
      @JsonProperty("kind") Long kind
  ) {
    this.text = text;
    this.type = type;
    this.path = path;
    this.range = range;
    this.name = name;
    this.kind = kind;
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

  /**
   * 获取范围。
   *
   * @return 范围信息。
   */
  public Range range() {
    return range;
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
   * 获取类型。
   *
   * @return 类型值。
   */
  public Long kind() {
    return kind;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SymbolSource)) return false;
    SymbolSource that = (SymbolSource) other;
    return Objects.equals(text, that.text)
        && Objects.equals(type, that.type)
        && Objects.equals(path, that.path)
        && Objects.equals(range, that.range)
        && Objects.equals(name, that.name)
        && Objects.equals(kind, that.kind);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, type, path, range, name, kind);
  }

  @Override
  public String toString() {
    return "SymbolSource{" +
        "text=" + text + "," +
        "type=" + type + "," +
        "path=" + path + "," +
        "range=" + range + "," +
        "name=" + name + "," +
        "kind=" + kind +
        "}";
  }
}
