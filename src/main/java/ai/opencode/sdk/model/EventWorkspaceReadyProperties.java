package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工作区就绪事件属性。
 *
 * @param name 名称。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventWorkspaceReadyProperties {
  @JsonProperty("name")
  private final String name;

  /** 使用字段创建事件工作区就绪属性。 */
  @JsonCreator
  public EventWorkspaceReadyProperties(
      @JsonProperty("name") String name
  ) {
    this.name = name;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventWorkspaceReadyProperties)) return false;
    EventWorkspaceReadyProperties that = (EventWorkspaceReadyProperties) other;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "EventWorkspaceReadyProperties{" +
        "name=" + name +
        "}";
  }
}
