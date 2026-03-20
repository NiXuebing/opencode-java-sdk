package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 检索符号接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param query 检索关键字。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindSymbolsRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("query")
  private final String query;

  /** 创建检索符号请求。 */
  @JsonCreator
  public FindSymbolsRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("query") String query
  ) {
    this.directory = directory;
    this.query = query;
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FindSymbolsRequest)) return false;
    FindSymbolsRequest that = (FindSymbolsRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(query, that.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, query);
  }

  @Override
  public String toString() {
    return "FindSymbolsRequest{" +
        "directory=" + directory + "," +
        "query=" + query +
        "}";
  }
}
