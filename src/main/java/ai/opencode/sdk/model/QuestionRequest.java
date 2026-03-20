package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 问题请求数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param questions questions列表。
 * @param tool 工具。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionRequest {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("questions")
  private final List<QuestionInfo> questions;
  @JsonProperty("tool")
  private final QuestionRequestTool tool;

  /** 使用字段创建问题请求。 */
  @JsonCreator
  public QuestionRequest(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("questions") List<QuestionInfo> questions,
      @JsonProperty("tool") QuestionRequestTool tool
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.questions = questions;
    this.tool = tool;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
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
   * 获取questions。
   *
   * @return questions列表。
   */
  public List<QuestionInfo> questions() {
    return questions;
  }

  /**
   * 获取工具。
   *
   * @return 工具。
   */
  public QuestionRequestTool tool() {
    return tool;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionRequest)) return false;
    QuestionRequest that = (QuestionRequest) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(questions, that.questions)
        && Objects.equals(tool, that.tool);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, questions, tool);
  }

  @Override
  public String toString() {
    return "QuestionRequest{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "questions=" + questions + "," +
        "tool=" + tool +
        "}";
  }
}
