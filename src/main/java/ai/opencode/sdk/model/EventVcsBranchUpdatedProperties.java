package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 版本控制分支已更新事件属性。
 *
 * @param branch 分支。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventVcsBranchUpdatedProperties {
  @JsonProperty("branch")
  private final String branch;

  /** 使用字段创建事件版本控制分支已更新属性。 */
  @JsonCreator
  public EventVcsBranchUpdatedProperties(
      @JsonProperty("branch") String branch
  ) {
    this.branch = branch;
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
    if (!(other instanceof EventVcsBranchUpdatedProperties)) return false;
    EventVcsBranchUpdatedProperties that = (EventVcsBranchUpdatedProperties) other;
    return Objects.equals(branch, that.branch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch);
  }

  @Override
  public String toString() {
    return "EventVcsBranchUpdatedProperties{" +
        "branch=" + branch +
        "}";
  }
}
