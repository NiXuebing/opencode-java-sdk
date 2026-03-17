package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 问题请求数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param questions questions列表。
 * @param tool 工具。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionRequest(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("questions") List<QuestionInfo> questions,
    @JsonProperty("tool") QuestionRequestTool tool) {}
