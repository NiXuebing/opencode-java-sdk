package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 事件会话差异属性。
 *
 * @param sessionID 目标会话 ID。
 * @param diff 差异列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventSessionDiffProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("diff") List<FileDiff> diff) {}
