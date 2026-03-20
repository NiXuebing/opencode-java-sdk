package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 列出项目接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProjectListRequest {
  @JsonProperty("directory")
  private final String directory;

  /** 创建项目列表请求。 */
  @JsonCreator
  public ProjectListRequest(
      @JsonProperty("directory") String directory
  ) {
    this.directory = directory;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProjectListRequest)) return false;
    ProjectListRequest that = (ProjectListRequest) other;
    return Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory);
  }

  @Override
  public String toString() {
    return "ProjectListRequest{" +
        "directory=" + directory +
        "}";
  }
}
