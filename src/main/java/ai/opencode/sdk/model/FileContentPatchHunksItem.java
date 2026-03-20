package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 文件内容补丁代码块项数据模型。
 *
 * @param oldStart 旧起始位置。
 * @param oldLines 旧行数。
 * @param newStart 新起始位置。
 * @param newLines 新行数。
 * @param lines 行列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileContentPatchHunksItem {
  @JsonProperty("oldStart")
  private final Double oldStart;
  @JsonProperty("oldLines")
  private final Double oldLines;
  @JsonProperty("newStart")
  private final Double newStart;
  @JsonProperty("newLines")
  private final Double newLines;
  @JsonProperty("lines")
  private final List<String> lines;

  /** 使用字段创建文件内容补丁代码块项。 */
  @JsonCreator
  public FileContentPatchHunksItem(
      @JsonProperty("oldStart") Double oldStart,
      @JsonProperty("oldLines") Double oldLines,
      @JsonProperty("newStart") Double newStart,
      @JsonProperty("newLines") Double newLines,
      @JsonProperty("lines") List<String> lines
  ) {
    this.oldStart = oldStart;
    this.oldLines = oldLines;
    this.newStart = newStart;
    this.newLines = newLines;
    this.lines = lines;
  }

  /**
   * 获取旧Start。
   *
   * @return 旧起始位置。
   */
  public Double oldStart() {
    return oldStart;
  }

  /**
   * 获取旧行。
   *
   * @return 旧行数。
   */
  public Double oldLines() {
    return oldLines;
  }

  /**
   * 获取new Start。
   *
   * @return 新起始位置。
   */
  public Double newStart() {
    return newStart;
  }

  /**
   * 获取new行。
   *
   * @return 新行数。
   */
  public Double newLines() {
    return newLines;
  }

  /**
   * 获取行。
   *
   * @return 行列表。
   */
  public List<String> lines() {
    return lines;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileContentPatchHunksItem)) return false;
    FileContentPatchHunksItem that = (FileContentPatchHunksItem) other;
    return Objects.equals(oldStart, that.oldStart)
        && Objects.equals(oldLines, that.oldLines)
        && Objects.equals(newStart, that.newStart)
        && Objects.equals(newLines, that.newLines)
        && Objects.equals(lines, that.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oldStart, oldLines, newStart, newLines, lines);
  }

  @Override
  public String toString() {
    return "FileContentPatchHunksItem{" +
        "oldStart=" + oldStart + "," +
        "oldLines=" + oldLines + "," +
        "newStart=" + newStart + "," +
        "newLines=" + newLines + "," +
        "lines=" + lines +
        "}";
  }
}
