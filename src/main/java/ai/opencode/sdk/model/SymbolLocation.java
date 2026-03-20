package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 符号Location数据模型。
 *
 * @param uri URI 地址。
 * @param range 范围信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SymbolLocation {
  @JsonProperty("uri")
  private final String uri;
  @JsonProperty("range")
  private final Range range;

  /** 使用字段创建符号Location。 */
  @JsonCreator
  public SymbolLocation(
      @JsonProperty("uri") String uri,
      @JsonProperty("range") Range range
  ) {
    this.uri = uri;
    this.range = range;
  }

  /**
   * 获取URI。
   *
   * @return URI 地址。
   */
  public String uri() {
    return uri;
  }

  /**
   * 获取范围。
   *
   * @return 范围信息。
   */
  public Range range() {
    return range;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SymbolLocation)) return false;
    SymbolLocation that = (SymbolLocation) other;
    return Objects.equals(uri, that.uri)
        && Objects.equals(range, that.range);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, range);
  }

  @Override
  public String toString() {
    return "SymbolLocation{" +
        "uri=" + uri + "," +
        "range=" + range +
        "}";
  }
}
