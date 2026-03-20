package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * PTY已退出事件属性。
 *
 * @param id 唯一标识。
 * @param exitCode 退出码。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventPtyExitedProperties {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("exitCode")
  private final Double exitCode;

  /** 使用字段创建事件PTY已退出属性。 */
  @JsonCreator
  public EventPtyExitedProperties(
      @JsonProperty("id") String id,
      @JsonProperty("exitCode") Double exitCode
  ) {
    this.id = id;
    this.exitCode = exitCode;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取退出代码。
   *
   * @return 退出码。
   */
  public Double exitCode() {
    return exitCode;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventPtyExitedProperties)) return false;
    EventPtyExitedProperties that = (EventPtyExitedProperties) other;
    return Objects.equals(id, that.id)
        && Objects.equals(exitCode, that.exitCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, exitCode);
  }

  @Override
  public String toString() {
    return "EventPtyExitedProperties{" +
        "id=" + id + "," +
        "exitCode=" + exitCode +
        "}";
  }
}
