package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 待办已更新事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param todos 待办列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTodoUpdatedProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("todos") List<Todo> todos) {}
