package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 输出格式JSON结构数据模型。
 *
 * @param type 类型标识。
 * @param schema 结构。
 * @param retryCount retryCount。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record OutputFormatJsonSchema(
    @JsonProperty("type") String type,
    @JsonProperty("schema") JSONSchema schema,
    @JsonProperty("retryCount") Long retryCount)
    implements OutputFormat {}
