package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工具状态已完成时间数据模型。
 *
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 * @param compacted 压缩完成时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolStateCompletedTime {
  @JsonProperty("start")
  private final Double start;
  @JsonProperty("end")
  private final Double end;
  @JsonProperty("compacted")
  private final Double compacted;

  /** 使用字段创建工具状态已完成时间。 */
  @JsonCreator
  public ToolStateCompletedTime(
      @JsonProperty("start") Double start,
      @JsonProperty("end") Double end,
      @JsonProperty("compacted") Double compacted
  ) {
    this.start = start;
    this.end = end;
    this.compacted = compacted;
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

  /**
   * 获取已压缩。
   *
   * @return 压缩完成时间。
   */
  public Double compacted() {
    return compacted;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolStateCompletedTime)) return false;
    ToolStateCompletedTime that = (ToolStateCompletedTime) other;
    return Objects.equals(start, that.start)
        && Objects.equals(end, that.end)
        && Objects.equals(compacted, that.compacted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end, compacted);
  }

  @Override
  public String toString() {
    return "ToolStateCompletedTime{" +
        "start=" + start + "," +
        "end=" + end + "," +
        "compacted=" + compacted +
        "}";
  }
}
