package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolStateRunning(
    @JsonProperty("status") String status,
    @JsonProperty("input") Map<String, JsonNode> input,
    @JsonProperty("title") String title,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("time") ToolStateRunningTime time)
    implements ToolState {}
