package ai.opencode.sdk.request;

import ai.opencode.sdk.model.Config;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 更新配置接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 更新配置的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigUpdateRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final Config body;

  /** 创建配置更新请求。 */
  @JsonCreator
  public ConfigUpdateRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("body") Config body
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
  public Config body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigUpdateRequest)) return false;
    ConfigUpdateRequest that = (ConfigUpdateRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, body);
  }

  @Override
  public String toString() {
    return "ConfigUpdateRequest{" +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
