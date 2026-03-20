package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 列出文件接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param path 目标文件或目录路径。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FileListRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("path")
  private final String path;

  /** 创建文件列表请求。 */
  @JsonCreator
  public FileListRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("path") String path
  ) {
    this.directory = directory;
    this.path = path;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
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
    if (!(other instanceof FileListRequest)) return false;
    FileListRequest that = (FileListRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(path, that.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, path);
  }

  @Override
  public String toString() {
    return "FileListRequest{" +
        "directory=" + directory + "," +
        "path=" + path +
        "}";
  }
}
