package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 配置实验性数据模型。
 *
 * @param disablePasteSummary disablepastesummary标记。
 * @param batchTool batch工具标记。
 * @param openTelemetry 打开Telemetry标记。
 * @param primaryTools primary工具列表。
 * @param continueLoopOnDeny continueloopondeny标记。
 * @param mcpTimeout MCPtimeout。
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
