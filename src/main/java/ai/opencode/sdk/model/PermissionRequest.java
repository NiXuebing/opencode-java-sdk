package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRequest(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("permission") String permission,
    @JsonProperty("patterns") List<String> patterns,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("always") List<String> always,
    @JsonProperty("tool") PermissionRequestTool tool
) {
}
