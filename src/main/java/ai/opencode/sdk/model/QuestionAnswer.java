package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.List;
import java.util.Objects;

/**
 * 问题Answer值对象。
 *
 * @param value 实际值。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionAnswer {
  private final List<String> value;

  /**
   * 使用实际值创建对象。
   *
   * @param value 实际值。
   */
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public QuestionAnswer(List<String> value) {
    this.value = value;
  }

  /**
   * 获取实际值。
   *
   * @return 实际值。
   */
  @JsonValue
  public List<String> value() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionAnswer)) return false;
    QuestionAnswer that = (QuestionAnswer) other;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "QuestionAnswer{" + "value=" + value + "}";
  }
}
