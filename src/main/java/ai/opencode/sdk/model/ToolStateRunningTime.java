package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工具状态运行中时间数据模型。
 *
 * @param start 分页起始位置或游标。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateRunningTime {
  @JsonProperty("start")
  private final Double start;

  /** 使用字段创建工具状态运行中时间。 */
  @JsonCreator
  public ToolStateRunningTime(
      @JsonProperty("start") Double start
  ) {
    this.start = start;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public Double start() {
    return start;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateRunningTime)) return false;
    ToolStateRunningTime that = (ToolStateRunningTime) other;
    return Objects.equals(start, that.start);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start);
  }

  @Override
  public String toString() {
    return "ToolStateRunningTime{" +
        "start=" + start +
        "}";
  }
}
