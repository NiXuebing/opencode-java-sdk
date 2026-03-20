package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * MCP状态失败数据模型。
 *
 * @param status 当前状态。
 * @param error 错误信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MCPStatusFailed implements MCPStatus {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("error")
  private final String error;

  /** 使用字段创建MCP状态失败。 */
  @JsonCreator
  public MCPStatusFailed(
      @JsonProperty("status") String status,
      @JsonProperty("error") String error
  ) {
    this.status = status;
    this.error = error;
  }

  /**
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
  }

  /**
   * 获取错误。
   *
   * @return 错误信息。
   */
  public String error() {
    return error;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof MCPStatusFailed)) return false;
    MCPStatusFailed that = (MCPStatusFailed) other;
    return Objects.equals(status, that.status)
        && Objects.equals(error, that.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, error);
  }

  @Override
  public String toString() {
    return "MCPStatusFailed{" +
        "status=" + status + "," +
        "error=" + error +
        "}";
  }
}
