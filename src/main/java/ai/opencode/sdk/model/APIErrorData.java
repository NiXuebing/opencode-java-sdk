package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * API错误详情。
 *
 * @param message 消息内容。
 * @param statusCode 状态代码。
 * @param isRetryable 是否可重试。
 * @param responseHeaders 服务端返回的响应头。
 * @param responseBody 服务端返回的原始响应体。
 * @param metadata 元数据映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record APIErrorData(
    @JsonProperty("message") String message,
    @JsonProperty("statusCode") Double statusCode,
    @JsonProperty("isRetryable") Boolean isRetryable,
    @JsonProperty("responseHeaders") Map<String, String> responseHeaders,
    @JsonProperty("responseBody") String responseBody,
    @JsonProperty("metadata") Map<String, String> metadata) {}
