package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 文件内容补丁数据模型。
 *
 * @param oldFileName 旧文件Name。
 * @param newFileName new文件Name。
 * @param oldHeader 旧标题头。
 * @param newHeader new标题头。
 * @param hunks 代码块列表。
 * @param index 索引。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileContentPatch {
  @JsonProperty("oldFileName")
  private final String oldFileName;
  @JsonProperty("newFileName")
  private final String newFileName;
  @JsonProperty("oldHeader")
  private final String oldHeader;
  @JsonProperty("newHeader")
  private final String newHeader;
  @JsonProperty("hunks")
  private final List<FileContentPatchHunksItem> hunks;
  @JsonProperty("index")
  private final String index;

  /** 使用字段创建文件内容补丁。 */
  @JsonCreator
  public FileContentPatch(
      @JsonProperty("oldFileName") String oldFileName,
      @JsonProperty("newFileName") String newFileName,
      @JsonProperty("oldHeader") String oldHeader,
      @JsonProperty("newHeader") String newHeader,
      @JsonProperty("hunks") List<FileContentPatchHunksItem> hunks,
      @JsonProperty("index") String index
  ) {
    this.oldFileName = oldFileName;
    this.newFileName = newFileName;
    this.oldHeader = oldHeader;
    this.newHeader = newHeader;
    this.hunks = hunks;
    this.index = index;
  }

  /**
   * 获取旧文件Name。
   *
   * @return 旧文件Name。
   */
  public String oldFileName() {
    return oldFileName;
  }

  /**
   * 获取new文件Name。
   *
   * @return new文件Name。
   */
  public String newFileName() {
    return newFileName;
  }

  /**
   * 获取旧标题头。
   *
   * @return 旧标题头。
   */
  public String oldHeader() {
    return oldHeader;
  }

  /**
   * 获取new标题头。
   *
   * @return new标题头。
   */
  public String newHeader() {
    return newHeader;
  }

  /**
   * 获取代码块。
   *
   * @return 代码块列表。
   */
  public List<FileContentPatchHunksItem> hunks() {
    return hunks;
  }

  /**
   * 获取index。
   *
   * @return 索引。
   */
  public String index() {
    return index;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileContentPatch)) return false;
    FileContentPatch that = (FileContentPatch) other;
    return Objects.equals(oldFileName, that.oldFileName)
        && Objects.equals(newFileName, that.newFileName)
        && Objects.equals(oldHeader, that.oldHeader)
        && Objects.equals(newHeader, that.newHeader)
        && Objects.equals(hunks, that.hunks)
        && Objects.equals(index, that.index);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oldFileName, newFileName, oldHeader, newHeader, hunks, index);
  }

  @Override
  public String toString() {
    return "FileContentPatch{" +
        "oldFileName=" + oldFileName + "," +
        "newFileName=" + newFileName + "," +
        "oldHeader=" + oldHeader + "," +
        "newHeader=" + newHeader + "," +
        "hunks=" + hunks + "," +
        "index=" + index +
        "}";
  }
}
