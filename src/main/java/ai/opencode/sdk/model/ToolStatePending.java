package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 工具状态等待中数据模型。
 *
 * @param status 当前状态。
 * @param input 输入映射。
 * @param raw 原始状态值。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStatePending implements ToolState {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("input")
  private final Map<String, JsonNode> input;
  @JsonProperty("raw")
  private final String raw;

  /** 使用字段创建工具状态等待中。 */
  @JsonCreator
  public ToolStatePending(
      @JsonProperty("status") String status,
      @JsonProperty("input") Map<String, JsonNode> input,
      @JsonProperty("raw") String raw
  ) {
    this.status = status;
    this.input = input;
    this.raw = raw;
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
   * 获取输入。
   *
   * @return 输入映射。
   */
  public Map<String, JsonNode> input() {
    return input;
  }

  /**
   * 获取raw。
   *
   * @return 原始状态值。
   */
  public String raw() {
    return raw;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStatePending)) return false;
    ToolStatePending that = (ToolStatePending) other;
    return Objects.equals(status, that.status)
        && Objects.equals(input, that.input)
        && Objects.equals(raw, that.raw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, input, raw);
  }

  @Override
  public String toString() {
    return "ToolStatePending{" +
        "status=" + status + "," +
        "input=" + input + "," +
        "raw=" + raw +
        "}";
  }
}
