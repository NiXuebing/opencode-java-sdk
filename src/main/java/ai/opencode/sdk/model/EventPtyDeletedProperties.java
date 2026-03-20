package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * PTY已删除事件属性。
 *
 * @param id 唯一标识。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventPtyDeletedProperties {
  @JsonProperty("id")
  private final String id;

  /** 使用字段创建事件PTY已删除属性。 */
  @JsonCreator
  public EventPtyDeletedProperties(
      @JsonProperty("id") String id
  ) {
    this.id = id;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventPtyDeletedProperties)) return false;
    EventPtyDeletedProperties that = (EventPtyDeletedProperties) other;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "EventPtyDeletedProperties{" +
        "id=" + id +
        "}";
  }
}
