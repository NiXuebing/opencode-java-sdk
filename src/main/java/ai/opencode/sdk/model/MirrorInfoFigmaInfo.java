package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MirrorInfoFigmaInfo(
    @JsonProperty("figma_url") String figmaUrl,
    @JsonProperty("figma_token") String figmaToken,
    @JsonProperty("start_node_id") String startNodeId
) {
}
