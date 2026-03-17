package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话撤回数据模型。
 *
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 * @param snapshot 是否启用快照。
 * @param diff 差异。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionRevert(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("partID") String partID,
    @JsonProperty("snapshot") String snapshot,
    @JsonProperty("diff") String diff) {}
