package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 项目命令数据模型。
 *
 * @param start 分页起始位置或游标。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProjectCommands {
  @JsonProperty("start")
  private final String start;

  /** 使用字段创建项目命令。 */
  @JsonCreator
  public ProjectCommands(
      @JsonProperty("start") String start
  ) {
    this.start = start;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public String start() {
    return start;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProjectCommands)) return false;
    ProjectCommands that = (ProjectCommands) other;
    return Objects.equals(start, that.start);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start);
  }

  @Override
  public String toString() {
    return "ProjectCommands{" +
        "start=" + start +
        "}";
  }
}
