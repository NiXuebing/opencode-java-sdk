package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件数据模型。
 *
 * @param path 目标文件或目录路径。
 * @param added added。
 * @param removed 已移除。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class File {
  @JsonProperty("path")
  private final String path;
  @JsonProperty("added")
  private final Long added;
  @JsonProperty("removed")
  private final Long removed;
  @JsonProperty("status")
  private final String status;

  /** 使用字段创建文件。 */
  @JsonCreator
  public File(
      @JsonProperty("path") String path,
      @JsonProperty("added") Long added,
      @JsonProperty("removed") Long removed,
      @JsonProperty("status") String status
  ) {
    this.path = path;
    this.added = added;
    this.removed = removed;
    this.status = status;
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
   * 获取added。
   *
   * @return added。
   */
  public Long added() {
    return added;
  }

  /**
   * 获取已移除。
   *
   * @return 已移除。
   */
  public Long removed() {
    return removed;
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
    if (!(other instanceof File)) return false;
    File that = (File) other;
    return Objects.equals(path, that.path)
        && Objects.equals(added, that.added)
        && Objects.equals(removed, that.removed)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, added, removed, status);
  }

  @Override
  public String toString() {
    return "File{" +
        "path=" + path + "," +
        "added=" + added + "," +
        "removed=" + removed + "," +
        "status=" + status +
        "}";
  }
}
