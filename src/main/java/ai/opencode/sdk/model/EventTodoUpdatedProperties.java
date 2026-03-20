package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 待办已更新事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param todos 待办列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventTodoUpdatedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("todos")
  private final List<Todo> todos;

  /** 使用字段创建事件待办已更新属性。 */
  @JsonCreator
  public EventTodoUpdatedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("todos") List<Todo> todos
  ) {
    this.sessionID = sessionID;
    this.todos = todos;
  }

  /**
   * 获取会话ID。
   *
   * @return 目标会话 ID。
   */
  public String sessionID() {
    return sessionID;
  }

  /**
   * 获取待办。
   *
   * @return 待办列表。
   */
  public List<Todo> todos() {
    return todos;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventTodoUpdatedProperties)) return false;
    EventTodoUpdatedProperties that = (EventTodoUpdatedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(todos, that.todos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, todos);
  }

  @Override
  public String toString() {
    return "EventTodoUpdatedProperties{" +
        "sessionID=" + sessionID + "," +
        "todos=" + todos +
        "}";
  }
}
