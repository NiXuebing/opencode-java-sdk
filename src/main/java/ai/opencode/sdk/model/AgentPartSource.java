package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 代理片段来源数据模型。
 *
 * @param value 实际值。
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AgentPartSource {
  @JsonProperty("value")
  private final String value;
  @JsonProperty("start")
  private final Long start;
  @JsonProperty("end")
  private final Long end;

  /** 使用字段创建代理片段来源。 */
  @JsonCreator
  public AgentPartSource(
      @JsonProperty("value") String value,
      @JsonProperty("start") Long start,
      @JsonProperty("end") Long end
  ) {
    this.value = value;
    this.start = start;
    this.end = end;
  }

  /**
   * 获取值。
   *
   * @return 实际值。
   */
  public String value() {
    return value;
  }

  /**
   * 获取start。
   *
   * @return 分页起始位置或游标。
   */
  public Long start() {
    return start;
  }

  /**
   * 获取end。
   *
   * @return 结束位置。
   */
  public Long end() {
    return end;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AgentPartSource)) return false;
    AgentPartSource that = (AgentPartSource) other;
    return Objects.equals(value, that.value)
        && Objects.equals(start, that.start)
        && Objects.equals(end, that.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, start, end);
  }

  @Override
  public String toString() {
    return "AgentPartSource{" +
        "value=" + value + "," +
        "start=" + start + "," +
        "end=" + end +
        "}";
  }
}
