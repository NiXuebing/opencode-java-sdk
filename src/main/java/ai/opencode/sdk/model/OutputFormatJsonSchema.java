package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 输出格式JSON结构数据模型。
 *
 * @param type 类型标识。
 * @param schema 结构。
 * @param retryCount 重试次数。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class OutputFormatJsonSchema implements OutputFormat {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("schema")
  private final JSONSchema schema;
  @JsonProperty("retryCount")
  private final Long retryCount;

  /** 使用字段创建输出格式JSON结构。 */
  @JsonCreator
  public OutputFormatJsonSchema(
      @JsonProperty("type") String type,
      @JsonProperty("schema") JSONSchema schema,
      @JsonProperty("retryCount") Long retryCount
  ) {
    this.type = type;
    this.schema = schema;
    this.retryCount = retryCount;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取结构。
   *
   * @return 结构。
   */
  public JSONSchema schema() {
    return schema;
  }

  /**
   * 获取重试Count。
   *
   * @return 重试次数。
   */
  public Long retryCount() {
    return retryCount;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof OutputFormatJsonSchema)) return false;
    OutputFormatJsonSchema that = (OutputFormatJsonSchema) other;
    return Objects.equals(type, that.type)
        && Objects.equals(schema, that.schema)
        && Objects.equals(retryCount, that.retryCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, schema, retryCount);
  }

  @Override
  public String toString() {
    return "OutputFormatJsonSchema{" +
        "type=" + type + "," +
        "schema=" + schema + "," +
        "retryCount=" + retryCount +
        "}";
  }
}
