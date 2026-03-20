package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 范围数据模型。
 *
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Range {
  @JsonProperty("start")
  private final RangeStart start;
  @JsonProperty("end")
  private final RangeEnd end;

  /** 使用字段创建范围。 */
  @JsonCreator
  public Range(
      @JsonProperty("start") RangeStart start,
      @JsonProperty("end") RangeEnd end
  ) {
    this.start = start;
    this.end = end;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public RangeStart start() {
    return start;
  }

  /**
   * 获取end。
   *
   * @return 结束位置。
   */
  public RangeEnd end() {
    return end;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Range)) return false;
    Range that = (Range) other;
    return Objects.equals(start, that.start)
        && Objects.equals(end, that.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  @Override
  public String toString() {
    return "Range{" +
        "start=" + start + "," +
        "end=" + end +
        "}";
  }
}
