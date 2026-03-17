package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

/**
 * 工具状态已完成数据模型。
 *
 * @param status 当前状态。
 * @param input 输入映射。
 * @param output 输出。
 * @param title 标题。
 * @param metadata 元数据映射。
 * @param time 时间。
 * @param attachments 附件列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolStateCompleted(
    @JsonProperty("status") String status,
    @JsonProperty("input") Map<String, JsonNode> input,
    @JsonProperty("output") String output,
    @JsonProperty("title") String title,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("time") ToolStateCompletedTime time,
    @JsonProperty("attachments") List<FilePart> attachments)
    implements ToolState {}
