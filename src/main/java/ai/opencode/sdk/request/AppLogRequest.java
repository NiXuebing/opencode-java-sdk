package ai.opencode.sdk.request;

import ai.opencode.sdk.model.AppLogBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 写入日志接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 写入日志的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AppLogRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final AppLogBody body;

  /** 创建应用日志请求。 */
  @JsonCreator
  public AppLogRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("body") AppLogBody body
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
  public AppLogBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AppLogRequest)) return false;
    AppLogRequest that = (AppLogRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, body);
  }

  @Override
  public String toString() {
    return "AppLogRequest{" +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
