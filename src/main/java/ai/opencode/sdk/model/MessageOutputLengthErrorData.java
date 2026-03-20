package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

/** 消息输出Length错误详情。 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MessageOutputLengthErrorData {


  /** 使用字段创建消息输出Length错误数据。 */
  @JsonCreator
  public MessageOutputLengthErrorData(

  ) {

  }


  @Override
  public boolean equals(Object other) {
    return other instanceof MessageOutputLengthErrorData;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "MessageOutputLengthErrorData{}";
  }
}
