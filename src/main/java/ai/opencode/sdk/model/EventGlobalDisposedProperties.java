package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

/** 全局已释放事件属性。 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventGlobalDisposedProperties {


  /** 使用字段创建事件全局已释放属性。 */
  @JsonCreator
  public EventGlobalDisposedProperties(

  ) {

  }


  @Override
  public boolean equals(Object other) {
    return other instanceof EventGlobalDisposedProperties;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "EventGlobalDisposedProperties{}";
  }
}
