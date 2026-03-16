package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MirrorEventEventChoicesItemDelta(
    @JsonProperty("content") String content,
    @JsonProperty("refusal") JsonNode refusal,
    @JsonProperty("role") String role,
    @JsonProperty("metadata") Map<String, JsonNode> metadata
) {
}
