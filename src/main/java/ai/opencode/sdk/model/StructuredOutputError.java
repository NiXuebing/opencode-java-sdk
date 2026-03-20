package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 结构化输出错误信息。
 *
 * @param name 名称。
 * @param data 数据内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StructuredOutputError implements AssistantMessageError, EventSessionErrorPropertiesError {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("data")
  private final StructuredOutputErrorData data;

  /** 使用字段创建结构化输出错误。 */
  @JsonCreator
  public StructuredOutputError(
      @JsonProperty("name") String name,
      @JsonProperty("data") StructuredOutputErrorData data
  ) {
    this.name = name;
    this.data = data;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  /**
   * 获取数据。
   *
   * @return 数据内容。
   */
  public StructuredOutputErrorData data() {
    return data;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StructuredOutputError)) return false;
    StructuredOutputError that = (StructuredOutputError) other;
    return Objects.equals(name, that.name)
        && Objects.equals(data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, data);
  }

  @Override
  public String toString() {
    return "StructuredOutputError{" +
        "name=" + name + "," +
        "data=" + data +
        "}";
  }
}
