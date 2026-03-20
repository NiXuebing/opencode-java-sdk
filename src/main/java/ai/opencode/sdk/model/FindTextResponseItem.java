package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 检索文本响应项数据模型。
 *
 * @param path 目标文件或目录路径。
 * @param lines 行。
 * @param lineNumber 行号。
 * @param absoluteOffset 绝对偏移量。
 * @param submatches 子匹配列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindTextResponseItem {
  @JsonProperty("path")
  private final FindTextResponseItemPath path;
  @JsonProperty("lines")
  private final FindTextResponseItemLines lines;
  @JsonProperty("line_number")
  private final Double lineNumber;
  @JsonProperty("absolute_offset")
  private final Double absoluteOffset;
  @JsonProperty("submatches")
  private final List<FindTextResponseItemSubmatchesItem> submatches;

  /** 使用字段创建检索文本响应项。 */
  @JsonCreator
  public FindTextResponseItem(
      @JsonProperty("path") FindTextResponseItemPath path,
      @JsonProperty("lines") FindTextResponseItemLines lines,
      @JsonProperty("line_number") Double lineNumber,
      @JsonProperty("absolute_offset") Double absoluteOffset,
      @JsonProperty("submatches") List<FindTextResponseItemSubmatchesItem> submatches
  ) {
    this.path = path;
    this.lines = lines;
    this.lineNumber = lineNumber;
    this.absoluteOffset = absoluteOffset;
    this.submatches = submatches;
  }

  /**
   * 获取路径。
   *
   * @return 目标文件或目录路径。
   */
  public FindTextResponseItemPath path() {
    return path;
  }

  /**
   * 获取行。
   *
   * @return 行。
   */
  public FindTextResponseItemLines lines() {
    return lines;
  }

  /**
   * 获取行number。
   *
   * @return 行号。
   */
  public Double lineNumber() {
    return lineNumber;
  }

  /**
   * 获取绝对偏移。
   *
   * @return 绝对偏移量。
   */
  public Double absoluteOffset() {
    return absoluteOffset;
  }

  /**
   * 获取子匹配。
   *
   * @return 子匹配列表。
   */
  public List<FindTextResponseItemSubmatchesItem> submatches() {
    return submatches;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FindTextResponseItem)) return false;
    FindTextResponseItem that = (FindTextResponseItem) other;
    return Objects.equals(path, that.path)
        && Objects.equals(lines, that.lines)
        && Objects.equals(lineNumber, that.lineNumber)
        && Objects.equals(absoluteOffset, that.absoluteOffset)
        && Objects.equals(submatches, that.submatches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, lines, lineNumber, absoluteOffset, submatches);
  }

  @Override
  public String toString() {
    return "FindTextResponseItem{" +
        "path=" + path + "," +
        "lines=" + lines + "," +
        "lineNumber=" + lineNumber + "," +
        "absoluteOffset=" + absoluteOffset + "," +
        "submatches=" + submatches +
        "}";
  }
}
