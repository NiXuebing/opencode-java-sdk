package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 检索文本响应项子匹配项数据模型。
 *
 * @param match 匹配。
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindTextResponseItemSubmatchesItem {
  @JsonProperty("match")
  private final FindTextResponseItemSubmatchesItemMatch match;
  @JsonProperty("start")
  private final Double start;
  @JsonProperty("end")
  private final Double end;

  /** 使用字段创建检索文本响应项子匹配项。 */
  @JsonCreator
  public FindTextResponseItemSubmatchesItem(
      @JsonProperty("match") FindTextResponseItemSubmatchesItemMatch match,
      @JsonProperty("start") Double start,
      @JsonProperty("end") Double end
  ) {
    this.match = match;
    this.start = start;
    this.end = end;
  }

  /**
   * 获取匹配。
   *
   * @return 匹配。
   */
  public FindTextResponseItemSubmatchesItemMatch match() {
    return match;
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
    if (!(other instanceof FindTextResponseItemSubmatchesItem)) return false;
    FindTextResponseItemSubmatchesItem that = (FindTextResponseItemSubmatchesItem) other;
    return Objects.equals(match, that.match)
        && Objects.equals(start, that.start)
        && Objects.equals(end, that.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(match, start, end);
  }

  @Override
  public String toString() {
    return "FindTextResponseItemSubmatchesItem{" +
        "match=" + match + "," +
        "start=" + start + "," +
        "end=" + end +
        "}";
  }
}
