package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 工具状态错误信息。
 *
 * @param status 当前状态。
 * @param input 输入映射。
 * @param error 错误信息。
 * @param metadata 元数据映射。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateError implements ToolState {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("input")
  private final Map<String, JsonNode> input;
  @JsonProperty("error")
  private final String error;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;
  @JsonProperty("time")
  private final ToolStateErrorTime time;

  /** 使用字段创建工具状态错误。 */
  @JsonCreator
  public ToolStateError(
      @JsonProperty("status") String status,
      @JsonProperty("input") Map<String, JsonNode> input,
      @JsonProperty("error") String error,
      @JsonProperty("metadata") Map<String, JsonNode> metadata,
      @JsonProperty("time") ToolStateErrorTime time
  ) {
    this.status = status;
    this.input = input;
    this.error = error;
    this.metadata = metadata;
    this.time = time;
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
   * 获取错误。
   *
   * @return 错误信息。
   */
  public String error() {
    return error;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, JsonNode> metadata() {
    return metadata;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public ToolStateErrorTime time() {
    return time;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateError)) return false;
    ToolStateError that = (ToolStateError) other;
    return Objects.equals(status, that.status)
        && Objects.equals(input, that.input)
        && Objects.equals(error, that.error)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, input, error, metadata, time);
  }

  @Override
  public String toString() {
    return "ToolStateError{" +
        "status=" + status + "," +
        "input=" + input + "," +
        "error=" + error + "," +
        "metadata=" + metadata + "," +
        "time=" + time +
        "}";
  }
}
