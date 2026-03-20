package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工具状态错误时间数据模型。
 *
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateErrorTime {
  @JsonProperty("start")
  private final Double start;
  @JsonProperty("end")
  private final Double end;

  /** 使用字段创建工具状态错误时间。 */
  @JsonCreator
  public ToolStateErrorTime(
      @JsonProperty("start") Double start,
      @JsonProperty("end") Double end
  ) {
    this.start = start;
    this.end = end;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public Double start() {
    return start;
  }

  /**
   * 获取end。
   *
   * @return 结束位置。
   */
  public Double end() {
    return end;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateErrorTime)) return false;
    ToolStateErrorTime that = (ToolStateErrorTime) other;
    return Objects.equals(start, that.start)
        && Objects.equals(end, that.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  @Override
  public String toString() {
    return "ToolStateErrorTime{" +
        "start=" + start + "," +
        "end=" + end +
        "}";
  }
}
