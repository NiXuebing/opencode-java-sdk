package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 用户消息Summary数据模型。
 *
 * @param title 标题。
 * @param body 请求体内容。
 * @param diffs diffs列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserMessageSummary(
    @JsonProperty("title") String title,
    @JsonProperty("body") String body,
    @JsonProperty("diffs") List<FileDiff> diffs) {}
