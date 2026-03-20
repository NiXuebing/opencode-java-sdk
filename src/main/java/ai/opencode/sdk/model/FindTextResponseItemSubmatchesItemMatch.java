package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 检索文本响应项子匹配项匹配数据模型。
 *
 * @param text 文本内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindTextResponseItemSubmatchesItemMatch {
  @JsonProperty("text")
  private final String text;

  /** 使用字段创建检索文本响应项子匹配项匹配。 */
  @JsonCreator
  public FindTextResponseItemSubmatchesItemMatch(
      @JsonProperty("text") String text
  ) {
    this.text = text;
  }

  /**
   * 获取文本。
   *
   * @return 文本内容。
   */
  public String text() {
    return text;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FindTextResponseItemSubmatchesItemMatch)) return false;
    FindTextResponseItemSubmatchesItemMatch that = (FindTextResponseItemSubmatchesItemMatch) other;
    return Objects.equals(text, that.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    return "FindTextResponseItemSubmatchesItemMatch{" +
        "text=" + text +
        "}";
  }
}
