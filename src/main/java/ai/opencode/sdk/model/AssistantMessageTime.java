package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 助手消息时间数据模型。
 *
 * @param created 已创建。
 * @param completed 已完成。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AssistantMessageTime {
  @JsonProperty("created")
  private final Double created;
  @JsonProperty("completed")
  private final Double completed;

  /** 使用字段创建助手消息时间。 */
  @JsonCreator
  public AssistantMessageTime(
      @JsonProperty("created") Double created,
      @JsonProperty("completed") Double completed
  ) {
    this.created = created;
    this.completed = completed;
  }

  /**
   * 获取已创建。
   *
   * @return 已创建。
   */
  public Double created() {
    return created;
  }

  /**
   * 获取已完成。
   *
   * @return 已完成。
   */
  public Double completed() {
    return completed;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AssistantMessageTime)) return false;
    AssistantMessageTime that = (AssistantMessageTime) other;
    return Objects.equals(created, that.created)
        && Objects.equals(completed, that.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, completed);
  }

  @Override
  public String toString() {
    return "AssistantMessageTime{" +
        "created=" + created + "," +
        "completed=" + completed +
        "}";
  }
}
