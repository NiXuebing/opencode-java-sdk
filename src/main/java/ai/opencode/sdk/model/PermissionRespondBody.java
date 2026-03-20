package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 权限响应请求体。
 *
 * @param response 响应。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionRespondBody {
  @JsonProperty("response")
  private final String response;

  /** 使用字段创建权限响应请求体。 */
  @JsonCreator
  public PermissionRespondBody(
      @JsonProperty("response") String response
  ) {
    this.response = response;
  }

  /**
   * 获取响应。
   *
   * @return 响应。
   */
  public String response() {
    return response;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionRespondBody)) return false;
    PermissionRespondBody that = (PermissionRespondBody) other;
    return Objects.equals(response, that.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response);
  }

  @Override
  public String toString() {
    return "PermissionRespondBody{" +
        "response=" + response +
        "}";
  }
}
