package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * MCP状态已禁用数据模型。
 *
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MCPStatusDisabled implements MCPStatus {
  @JsonProperty("status")
  private final String status;

  /** 使用字段创建MCP状态已禁用。 */
  @JsonCreator
  public MCPStatusDisabled(
      @JsonProperty("status") String status
  ) {
    this.status = status;
  }

  /**
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof MCPStatusDisabled)) return false;
    MCPStatusDisabled that = (MCPStatusDisabled) other;
    return Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    return "MCPStatusDisabled{" +
        "status=" + status +
        "}";
  }
}
