package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MirrorInfo(
    @JsonProperty("uuid") String uuid,
    @JsonProperty("sandbox_id") String sandboxId,
    @JsonProperty("figma_info") MirrorInfoFigmaInfo figmaInfo,
    @JsonProperty("session_id") String sessionId
) {
}
