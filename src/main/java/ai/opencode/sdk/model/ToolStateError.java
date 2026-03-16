package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolStateError(
    @JsonProperty("status") String status,
    @JsonProperty("input") Map<String, JsonNode> input,
    @JsonProperty("error") String error,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("time") ToolStateErrorTime time
) implements ToolState {
}
