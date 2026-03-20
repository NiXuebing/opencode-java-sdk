package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

/** 服务端已连接事件属性。 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventServerConnectedProperties {


  /** 使用字段创建事件服务端已连接属性。 */
  @JsonCreator
  public EventServerConnectedProperties(

  ) {

  }


  @Override
  public boolean equals(Object other) {
    return other instanceof EventServerConnectedProperties;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "EventServerConnectedProperties{}";
  }
}
