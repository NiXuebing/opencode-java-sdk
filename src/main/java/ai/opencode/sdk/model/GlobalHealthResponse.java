package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 全局健康状态响应数据。
 *
 * @param healthy 服务端是否健康。
 * @param version 版本号。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GlobalHealthResponse {
  @JsonProperty("healthy")
  private final Boolean healthy;
  @JsonProperty("version")
  private final String version;

  /** 使用字段创建全局健康状态响应。 */
  @JsonCreator
  public GlobalHealthResponse(
      @JsonProperty("healthy") Boolean healthy,
      @JsonProperty("version") String version
  ) {
    this.healthy = healthy;
    this.version = version;
  }

  /**
   * 获取healthy。
   *
   * @return 服务端是否健康。
   */
  public Boolean healthy() {
    return healthy;
  }

  /**
   * 获取版本。
   *
   * @return 版本号。
   */
  public String version() {
    return version;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof GlobalHealthResponse)) return false;
    GlobalHealthResponse that = (GlobalHealthResponse) other;
    return Objects.equals(healthy, that.healthy)
        && Objects.equals(version, that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthy, version);
  }

  @Override
  public String toString() {
    return "GlobalHealthResponse{" +
        "healthy=" + healthy + "," +
        "version=" + version +
        "}";
  }
}
