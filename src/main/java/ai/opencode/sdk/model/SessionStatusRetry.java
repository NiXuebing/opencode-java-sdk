package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话状态Retry数据模型。
 *
 * @param type 类型标识。
 * @param attempt attempt。
 * @param message 消息内容。
 * @param next next。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionStatusRetry(
    @JsonProperty("type") String type,
    @JsonProperty("attempt") Double attempt,
    @JsonProperty("message") String message,
    @JsonProperty("next") Double next)
    implements SessionStatus {}
