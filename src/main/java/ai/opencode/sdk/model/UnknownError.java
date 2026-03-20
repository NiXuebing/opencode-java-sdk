package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 未知错误信息。
 *
 * @param name 名称。
 * @param data 数据内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UnknownError implements AssistantMessageError, EventSessionErrorPropertiesError {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("data")
  private final UnknownErrorData data;

  /** 使用字段创建未知错误。 */
  @JsonCreator
  public UnknownError(
      @JsonProperty("name") String name,
      @JsonProperty("data") UnknownErrorData data
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
  public UnknownErrorData data() {
    return data;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof UnknownError)) return false;
    UnknownError that = (UnknownError) other;
    return Objects.equals(name, that.name)
        && Objects.equals(data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, data);
  }

  @Override
  public String toString() {
    return "UnknownError{" +
        "name=" + name + "," +
        "data=" + data +
        "}";
  }
}
