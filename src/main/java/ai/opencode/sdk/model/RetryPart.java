package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 重试片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param attempt 尝试次数。
 * @param error 错误信息。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RetryPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("attempt") Double attempt,
    @JsonProperty("error") APIError error,
    @JsonProperty("time") RetryPartTime time)
    implements Part {}
