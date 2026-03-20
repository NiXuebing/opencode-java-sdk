package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 列出会话接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param roots 是否仅返回根会话。
 * @param start 分页起始位置或游标。
 * @param search 搜索关键字。
 * @param limit 返回结果数量上限。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionListRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("roots")
  private final Boolean roots;
  @JsonProperty("start")
  private final Double start;
  @JsonProperty("search")
  private final String search;
  @JsonProperty("limit")
  private final Double limit;

  /** 创建会话列表请求。 */
  @JsonCreator
  public SessionListRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("roots") Boolean roots,
      @JsonProperty("start") Double start,
      @JsonProperty("search") String search,
      @JsonProperty("limit") Double limit
  ) {
    this.directory = directory;
    this.roots = roots;
    this.start = start;
    this.search = search;
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
   * 获取roots。
   *
   * @return 是否仅返回根会话。
   */
  public Boolean roots() {
    return roots;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public Double start() {
    return start;
  }

  /**
   * 获取search。
   *
   * @return 搜索关键字。
   */
  public String search() {
    return search;
  }

  /**
   * 获取限制。
   *
   * @return 返回结果数量上限。
   */
  public Double limit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionListRequest)) return false;
    SessionListRequest that = (SessionListRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(roots, that.roots)
        && Objects.equals(start, that.start)
        && Objects.equals(search, that.search)
        && Objects.equals(limit, that.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, roots, start, search, limit);
  }

  @Override
  public String toString() {
    return "SessionListRequest{" +
        "directory=" + directory + "," +
        "roots=" + roots + "," +
        "start=" + start + "," +
        "search=" + search + "," +
        "limit=" + limit +
        "}";
  }
}
