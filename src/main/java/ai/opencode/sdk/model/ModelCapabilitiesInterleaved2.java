package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 模型能力交错数据模型。
 *
 * @param field 字段。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelCapabilitiesInterleaved2 {
  @JsonProperty("field")
  private final String field;

  /** 使用字段创建模型能力交错。 */
  @JsonCreator
  public ModelCapabilitiesInterleaved2(
      @JsonProperty("field") String field
  ) {
    this.field = field;
  }

  /**
   * 获取字段。
   *
   * @return 字段。
   */
  public String field() {
    return field;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelCapabilitiesInterleaved2)) return false;
    ModelCapabilitiesInterleaved2 that = (ModelCapabilitiesInterleaved2) other;
    return Objects.equals(field, that.field);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field);
  }

  @Override
  public String toString() {
    return "ModelCapabilitiesInterleaved2{" +
        "field=" + field +
        "}";
  }
}
