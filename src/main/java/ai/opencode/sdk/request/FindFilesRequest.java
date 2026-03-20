package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 检索文件接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param query 检索关键字。
 * @param dirs 参与检索的目录列表。
 * @param type 类型标识。
 * @param limit 返回结果数量上限。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindFilesRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("query")
  private final String query;
  @JsonProperty("dirs")
  private final String dirs;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("limit")
  private final Long limit;

  /** 创建检索文件请求。 */
  @JsonCreator
  public FindFilesRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("query") String query,
      @JsonProperty("dirs") String dirs,
      @JsonProperty("type") String type,
      @JsonProperty("limit") Long limit
  ) {
    this.directory = directory;
    this.query = query;
    this.dirs = dirs;
    this.type = type;
    this.limit = limit;
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
   * 获取query。
   *
   * @return 检索关键字。
   */
  public String query() {
    return query;
  }

  /**
   * 获取dirs。
   *
   * @return 参与检索的目录列表。
   */
  public String dirs() {
    return dirs;
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
   * 获取限制。
   *
   * @return 返回结果数量上限。
   */
  public Long limit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FindFilesRequest)) return false;
    FindFilesRequest that = (FindFilesRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(query, that.query)
        && Objects.equals(dirs, that.dirs)
        && Objects.equals(type, that.type)
        && Objects.equals(limit, that.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, query, dirs, type, limit);
  }

  @Override
  public String toString() {
    return "FindFilesRequest{" +
        "directory=" + directory + "," +
        "query=" + query + "," +
        "dirs=" + dirs + "," +
        "type=" + type + "," +
        "limit=" + limit +
        "}";
  }
}
