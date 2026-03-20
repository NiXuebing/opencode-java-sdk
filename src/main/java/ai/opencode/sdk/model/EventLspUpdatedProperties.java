package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

/** LSP已更新事件属性。 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventLspUpdatedProperties {


  /** 使用字段创建事件LSP已更新属性。 */
  @JsonCreator
  public EventLspUpdatedProperties(

  ) {

  }


  @Override
  public boolean equals(Object other) {
    return other instanceof EventLspUpdatedProperties;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "EventLspUpdatedProperties{}";
  }
}
