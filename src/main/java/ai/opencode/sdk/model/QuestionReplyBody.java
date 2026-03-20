package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 问题回复请求体。
 *
 * @param answers 回答列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionReplyBody {
  @JsonProperty("answers")
  private final List<QuestionAnswer> answers;

  /** 使用字段创建问题回复请求体。 */
  @JsonCreator
  public QuestionReplyBody(
      @JsonProperty("answers") List<QuestionAnswer> answers
  ) {
    this.answers = answers;
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
    if (!(other instanceof QuestionReplyBody)) return false;
    QuestionReplyBody that = (QuestionReplyBody) other;
    return Objects.equals(answers, that.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answers);
  }

  @Override
  public String toString() {
    return "QuestionReplyBody{" +
        "answers=" + answers +
        "}";
  }
}
