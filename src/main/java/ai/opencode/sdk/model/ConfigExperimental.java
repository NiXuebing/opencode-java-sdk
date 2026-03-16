package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigExperimental(
    @JsonProperty("disable_paste_summary") Boolean disablePasteSummary,
    @JsonProperty("batch_tool") Boolean batchTool,
    @JsonProperty("openTelemetry") Boolean openTelemetry,
    @JsonProperty("primary_tools") List<String> primaryTools,
    @JsonProperty("continue_loop_on_deny") Boolean continueLoopOnDeny,
    @JsonProperty("mcp_timeout") Long mcpTimeout
) {
}
