package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息输出Length错误信息。
 *
 * @param name 名称。
 * @param data 数据内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MessageOutputLengthError implements AssistantMessageError, EventSessionErrorPropertiesError {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("data")
  private final MessageOutputLengthErrorData data;

  /** 使用字段创建消息输出Length错误。 */
  @JsonCreator
  public MessageOutputLengthError(
      @JsonProperty("name") String name,
      @JsonProperty("data") MessageOutputLengthErrorData data
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
  public MessageOutputLengthErrorData data() {
    return data;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof MessageOutputLengthError)) return false;
    MessageOutputLengthError that = (MessageOutputLengthError) other;
    return Objects.equals(name, that.name)
        && Objects.equals(data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, data);
  }

  @Override
  public String toString() {
    return "MessageOutputLengthError{" +
        "name=" + name + "," +
        "data=" + data +
        "}";
  }
}
