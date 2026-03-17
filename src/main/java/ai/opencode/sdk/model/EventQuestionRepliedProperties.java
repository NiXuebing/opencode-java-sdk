package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 事件问题已响应属性。
 *
 * @param sessionID 目标会话 ID。
 * @param requestID 请求 ID。
 * @param answers answers列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventQuestionRepliedProperties(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("requestID") String requestID,
    @JsonProperty("answers") List<QuestionAnswer> answers) {}
