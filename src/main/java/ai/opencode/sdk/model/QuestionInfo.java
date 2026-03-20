package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 问题信息数据模型。
 *
 * @param question 问题。
 * @param header 标题。
 * @param options 选项列表。
 * @param multiple 是否允许多选。
 * @param custom 是否允许自定义输入。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionInfo {
  @JsonProperty("question")
  private final String question;
  @JsonProperty("header")
  private final String header;
  @JsonProperty("options")
  private final List<QuestionOption> options;
  @JsonProperty("multiple")
  private final Boolean multiple;
  @JsonProperty("custom")
  private final Boolean custom;

  /** 使用字段创建问题信息。 */
  @JsonCreator
  public QuestionInfo(
      @JsonProperty("question") String question,
      @JsonProperty("header") String header,
      @JsonProperty("options") List<QuestionOption> options,
      @JsonProperty("multiple") Boolean multiple,
      @JsonProperty("custom") Boolean custom
  ) {
    this.question = question;
    this.header = header;
    this.options = options;
    this.multiple = multiple;
    this.custom = custom;
  }

  /**
   * 获取问题。
   *
   * @return 问题。
   */
  public String question() {
    return question;
  }

  /**
   * 获取标题头。
   *
   * @return 标题。
   */
  public String header() {
    return header;
  }

  /**
   * 获取选项。
   *
   * @return 选项列表。
   */
  public List<QuestionOption> options() {
    return options;
  }

  /**
   * 获取多选。
   *
   * @return 是否允许多选。
   */
  public Boolean multiple() {
    return multiple;
  }

  /**
   * 获取custom。
   *
   * @return 是否允许自定义输入。
   */
  public Boolean custom() {
    return custom;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionInfo)) return false;
    QuestionInfo that = (QuestionInfo) other;
    return Objects.equals(question, that.question)
        && Objects.equals(header, that.header)
        && Objects.equals(options, that.options)
        && Objects.equals(multiple, that.multiple)
        && Objects.equals(custom, that.custom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question, header, options, multiple, custom);
  }

  @Override
  public String toString() {
    return "QuestionInfo{" +
        "question=" + question + "," +
        "header=" + header + "," +
        "options=" + options + "," +
        "multiple=" + multiple + "," +
        "custom=" + custom +
        "}";
  }
}
