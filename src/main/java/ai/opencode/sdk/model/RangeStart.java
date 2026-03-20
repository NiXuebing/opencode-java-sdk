package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 范围Start数据模型。
 *
 * @param line 行。
 * @param character 字符位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RangeStart {
  @JsonProperty("line")
  private final Double line;
  @JsonProperty("character")
  private final Double character;

  /** 使用字段创建范围Start。 */
  @JsonCreator
  public RangeStart(
      @JsonProperty("line") Double line,
      @JsonProperty("character") Double character
  ) {
    this.line = line;
    this.character = character;
  }

  /**
   * 获取行。
   *
   * @return 行。
   */
  public Double line() {
    return line;
  }

  /**
   * 获取字符。
   *
   * @return 字符位置。
   */
  public Double character() {
    return character;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof RangeStart)) return false;
    RangeStart that = (RangeStart) other;
    return Objects.equals(line, that.line)
        && Objects.equals(character, that.character);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line, character);
  }

  @Override
  public String toString() {
    return "RangeStart{" +
        "line=" + line + "," +
        "character=" + character +
        "}";
  }
}
