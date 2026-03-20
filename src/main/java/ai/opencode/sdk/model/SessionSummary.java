package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 会话摘要数据模型。
 *
 * @param additions 新增行数。
 * @param deletions 删除行数。
 * @param files 文件数量。
 * @param diffs 差异列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionSummary {
  @JsonProperty("additions")
  private final Double additions;
  @JsonProperty("deletions")
  private final Double deletions;
  @JsonProperty("files")
  private final Double files;
  @JsonProperty("diffs")
  private final List<FileDiff> diffs;

  /** 使用字段创建会话摘要。 */
  @JsonCreator
  public SessionSummary(
      @JsonProperty("additions") Double additions,
      @JsonProperty("deletions") Double deletions,
      @JsonProperty("files") Double files,
      @JsonProperty("diffs") List<FileDiff> diffs
  ) {
    this.additions = additions;
    this.deletions = deletions;
    this.files = files;
    this.diffs = diffs;
  }

  /**
   * 获取additions。
   *
   * @return 新增行数。
   */
  public Double additions() {
    return additions;
  }

  /**
   * 获取删除行数。
   *
   * @return 删除行数。
   */
  public Double deletions() {
    return deletions;
  }

  /**
   * 获取文件。
   *
   * @return 文件数量。
   */
  public Double files() {
    return files;
  }

  /**
   * 获取diffs。
   *
   * @return 差异列表。
   */
  public List<FileDiff> diffs() {
    return diffs;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionSummary)) return false;
    SessionSummary that = (SessionSummary) other;
    return Objects.equals(additions, that.additions)
        && Objects.equals(deletions, that.deletions)
        && Objects.equals(files, that.files)
        && Objects.equals(diffs, that.diffs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additions, deletions, files, diffs);
  }

  @Override
  public String toString() {
    return "SessionSummary{" +
        "additions=" + additions + "," +
        "deletions=" + deletions + "," +
        "files=" + files + "," +
        "diffs=" + diffs +
        "}";
  }
}
