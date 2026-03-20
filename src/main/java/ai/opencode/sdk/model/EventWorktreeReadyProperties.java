package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工作树就绪事件属性。
 *
 * @param name 名称。
 * @param branch 分支。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventWorktreeReadyProperties {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("branch")
  private final String branch;

  /** 使用字段创建事件工作树就绪属性。 */
  @JsonCreator
  public EventWorktreeReadyProperties(
      @JsonProperty("name") String name,
      @JsonProperty("branch") String branch
  ) {
    this.name = name;
    this.branch = branch;
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
   * 获取分支。
   *
   * @return 分支。
   */
  public String branch() {
    return branch;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventWorktreeReadyProperties)) return false;
    EventWorktreeReadyProperties that = (EventWorktreeReadyProperties) other;
    return Objects.equals(name, that.name)
        && Objects.equals(branch, that.branch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, branch);
  }

  @Override
  public String toString() {
    return "EventWorktreeReadyProperties{" +
        "name=" + name + "," +
        "branch=" + branch +
        "}";
  }
}
