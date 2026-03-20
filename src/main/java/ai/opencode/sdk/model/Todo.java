package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 待办数据模型。
 *
 * @param content 正文内容。
 * @param status 当前状态。
 * @param priority 优先级。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Todo {
  @JsonProperty("content")
  private final String content;
  @JsonProperty("status")
  private final String status;
  @JsonProperty("priority")
  private final String priority;

  /** 使用字段创建待办。 */
  @JsonCreator
  public Todo(
      @JsonProperty("content") String content,
      @JsonProperty("status") String status,
      @JsonProperty("priority") String priority
  ) {
    this.content = content;
    this.status = status;
    this.priority = priority;
  }

  /**
   * 获取内容。
   *
   * @return 正文内容。
   */
  public String content() {
    return content;
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
   * 获取优先级。
   *
   * @return 优先级。
   */
  public String priority() {
    return priority;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Todo)) return false;
    Todo that = (Todo) other;
    return Objects.equals(content, that.content)
        && Objects.equals(status, that.status)
        && Objects.equals(priority, that.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, status, priority);
  }

  @Override
  public String toString() {
    return "Todo{" +
        "content=" + content + "," +
        "status=" + status + "," +
        "priority=" + priority +
        "}";
  }
}
