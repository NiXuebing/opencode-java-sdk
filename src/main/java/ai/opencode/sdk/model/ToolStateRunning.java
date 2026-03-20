package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 工具状态运行中数据模型。
 *
 * @param status 当前状态。
 * @param input 输入映射。
 * @param title 标题。
 * @param metadata 元数据映射。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateRunning implements ToolState {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("input")
  private final Map<String, JsonNode> input;
  @JsonProperty("title")
  private final String title;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;
  @JsonProperty("time")
  private final ToolStateRunningTime time;

  /** 使用字段创建工具状态运行中。 */
  @JsonCreator
  public ToolStateRunning(
      @JsonProperty("status") String status,
      @JsonProperty("input") Map<String, JsonNode> input,
      @JsonProperty("title") String title,
      @JsonProperty("metadata") Map<String, JsonNode> metadata,
      @JsonProperty("time") ToolStateRunningTime time
  ) {
    this.status = status;
    this.input = input;
    this.title = title;
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
   * 获取title。
   *
   * @return 标题。
   */
  public String title() {
    return title;
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
  public ToolStateRunningTime time() {
    return time;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateRunning)) return false;
    ToolStateRunning that = (ToolStateRunning) other;
    return Objects.equals(status, that.status)
        && Objects.equals(input, that.input)
        && Objects.equals(title, that.title)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, input, title, metadata, time);
  }

  @Override
  public String toString() {
    return "ToolStateRunning{" +
        "status=" + status + "," +
        "input=" + input + "," +
        "title=" + title + "," +
        "metadata=" + metadata + "," +
        "time=" + time +
        "}";
  }
}
