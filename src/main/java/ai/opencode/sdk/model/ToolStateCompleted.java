package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 工具状态已完成数据模型。
 *
 * @param status 当前状态。
 * @param input 输入映射。
 * @param output 输出。
 * @param title 标题。
 * @param metadata 元数据映射。
 * @param time 时间。
 * @param attachments 附件列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateCompleted implements ToolState {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("input")
  private final Map<String, JsonNode> input;
  @JsonProperty("output")
  private final String output;
  @JsonProperty("title")
  private final String title;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;
  @JsonProperty("time")
  private final ToolStateCompletedTime time;
  @JsonProperty("attachments")
  private final List<FilePart> attachments;

  /** 使用字段创建工具状态已完成。 */
  @JsonCreator
  public ToolStateCompleted(
      @JsonProperty("status") String status,
      @JsonProperty("input") Map<String, JsonNode> input,
      @JsonProperty("output") String output,
      @JsonProperty("title") String title,
      @JsonProperty("metadata") Map<String, JsonNode> metadata,
      @JsonProperty("time") ToolStateCompletedTime time,
      @JsonProperty("attachments") List<FilePart> attachments
  ) {
    this.status = status;
    this.input = input;
    this.output = output;
    this.title = title;
    this.metadata = metadata;
    this.time = time;
    this.attachments = attachments;
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
   * 获取输出。
   *
   * @return 输出。
   */
  public String output() {
    return output;
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
  public ToolStateCompletedTime time() {
    return time;
  }

  /**
   * 获取附件。
   *
   * @return 附件列表。
   */
  public List<FilePart> attachments() {
    return attachments;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateCompleted)) return false;
    ToolStateCompleted that = (ToolStateCompleted) other;
    return Objects.equals(status, that.status)
        && Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(title, that.title)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(time, that.time)
        && Objects.equals(attachments, that.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, input, output, title, metadata, time, attachments);
  }

  @Override
  public String toString() {
    return "ToolStateCompleted{" +
        "status=" + status + "," +
        "input=" + input + "," +
        "output=" + output + "," +
        "title=" + title + "," +
        "metadata=" + metadata + "," +
        "time=" + time + "," +
        "attachments=" + attachments +
        "}";
  }
}
