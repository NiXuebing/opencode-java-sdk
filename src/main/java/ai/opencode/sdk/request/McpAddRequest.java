package ai.opencode.sdk.request;

import ai.opencode.sdk.model.McpAddBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 添加 MCP 服务接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 添加 MCP 服务的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class McpAddRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final McpAddBody body;

  /** 创建MCP Add请求。 */
  @JsonCreator
  public McpAddRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("body") McpAddBody body
  ) {
    this.directory = directory;
    this.body = body;
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
   * 获取请求体。
   *
   * @return 请求体内容。
   */
  public McpAddBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof McpAddRequest)) return false;
    McpAddRequest that = (McpAddRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, body);
  }

  @Override
  public String toString() {
    return "McpAddRequest{" +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
