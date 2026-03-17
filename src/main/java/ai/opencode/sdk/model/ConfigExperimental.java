package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 配置实验性数据模型。
 *
 * @param disablePasteSummary 是否禁用粘贴摘要。
 * @param batchTool 是否启用批量工具。
 * @param openTelemetry 是否启用 OpenTelemetry。
 * @param primaryTools 主要工具列表。
 * @param continueLoopOnDeny 是否在拒绝后继续循环。
 * @param mcpTimeout MCP 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigExperimental(
    @JsonProperty("disable_paste_summary") Boolean disablePasteSummary,
    @JsonProperty("batch_tool") Boolean batchTool,
    @JsonProperty("openTelemetry") Boolean openTelemetry,
    @JsonProperty("primary_tools") List<String> primaryTools,
    @JsonProperty("continue_loop_on_deny") Boolean continueLoopOnDeny,
    @JsonProperty("mcp_timeout") Long mcpTimeout) {}
