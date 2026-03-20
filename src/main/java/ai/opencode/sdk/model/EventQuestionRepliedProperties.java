package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 问题已响应事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param requestID 请求 ID。
 * @param answers 回答列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventQuestionRepliedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("requestID")
  private final String requestID;
  @JsonProperty("answers")
  private final List<QuestionAnswer> answers;

  /** 使用字段创建事件问题已响应属性。 */
  @JsonCreator
  public EventQuestionRepliedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("requestID") String requestID,
      @JsonProperty("answers") List<QuestionAnswer> answers
  ) {
    this.sessionID = sessionID;
    this.requestID = requestID;
    this.answers = answers;
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
   * 获取请求ID。
   *
   * @return 请求 ID。
   */
  public String requestID() {
    return requestID;
  }

  /**
   * 获取回答。
   *
   * @return 回答列表。
   */
  public List<QuestionAnswer> answers() {
    return answers;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventQuestionRepliedProperties)) return false;
    EventQuestionRepliedProperties that = (EventQuestionRepliedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(requestID, that.requestID)
        && Objects.equals(answers, that.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, requestID, answers);
  }

  @Override
  public String toString() {
    return "EventQuestionRepliedProperties{" +
        "sessionID=" + sessionID + "," +
        "requestID=" + requestID + "," +
        "answers=" + answers +
        "}";
  }
}
