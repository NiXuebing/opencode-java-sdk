package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 上下文溢出错误详情。
 *
 * @param message 消息内容。
 * @param responseBody 服务端返回的原始响应体。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ContextOverflowErrorData(
    @JsonProperty("message") String message, @JsonProperty("responseBody") String responseBody) {}
