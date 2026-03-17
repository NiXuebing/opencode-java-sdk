package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Structured输出错误详情。
 *
 * @param message 消息内容。
 * @param retries retries。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StructuredOutputErrorData(
    @JsonProperty("message") String message, @JsonProperty("retries") Double retries) {}
