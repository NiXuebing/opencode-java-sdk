package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 问题Option数据模型。
 *
 * @param label 显示标签。
 * @param description 描述信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionOption {
  @JsonProperty("label")
  private final String label;
  @JsonProperty("description")
  private final String description;

  /** 使用字段创建问题Option。 */
  @JsonCreator
  public QuestionOption(
      @JsonProperty("label") String label,
      @JsonProperty("description") String description
  ) {
    this.label = label;
    this.description = description;
  }

  /**
   * 获取标签。
   *
   * @return 显示标签。
   */
  public String label() {
    return label;
  }

  /**
   * 获取description。
   *
   * @return 描述信息。
   */
  public String description() {
    return description;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionOption)) return false;
    QuestionOption that = (QuestionOption) other;
    return Objects.equals(label, that.label)
        && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, description);
  }

  @Override
  public String toString() {
    return "QuestionOption{" +
        "label=" + label + "," +
        "description=" + description +
        "}";
  }
}
