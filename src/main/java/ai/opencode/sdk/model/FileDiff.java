package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件差异数据模型。
 *
 * @param file 文件信息。
 * @param before 变更前内容。
 * @param after 变更后内容。
 * @param additions 新增行数。
 * @param deletions 删除行数。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileDiff {
  @JsonProperty("file")
  private final String file;
  @JsonProperty("before")
  private final String before;
  @JsonProperty("after")
  private final String after;
  @JsonProperty("additions")
  private final Double additions;
  @JsonProperty("deletions")
  private final Double deletions;
  @JsonProperty("status")
  private final String status;

  /** 使用字段创建文件差异。 */
  @JsonCreator
  public FileDiff(
      @JsonProperty("file") String file,
      @JsonProperty("before") String before,
      @JsonProperty("after") String after,
      @JsonProperty("additions") Double additions,
      @JsonProperty("deletions") Double deletions,
      @JsonProperty("status") String status
  ) {
    this.file = file;
    this.before = before;
    this.after = after;
    this.additions = additions;
    this.deletions = deletions;
    this.status = status;
  }

  /**
   * 获取文件。
   *
   * @return 文件信息。
   */
  public String file() {
    return file;
  }

  /**
   * 获取before。
   *
   * @return 变更前内容。
   */
  public String before() {
    return before;
  }

  /**
   * 获取after。
   *
   * @return 变更后内容。
   */
  public String after() {
    return after;
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
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileDiff)) return false;
    FileDiff that = (FileDiff) other;
    return Objects.equals(file, that.file)
        && Objects.equals(before, that.before)
        && Objects.equals(after, that.after)
        && Objects.equals(additions, that.additions)
        && Objects.equals(deletions, that.deletions)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, before, after, additions, deletions, status);
  }

  @Override
  public String toString() {
    return "FileDiff{" +
        "file=" + file + "," +
        "before=" + before + "," +
        "after=" + after + "," +
        "additions=" + additions + "," +
        "deletions=" + deletions + "," +
        "status=" + status +
        "}";
  }
}
