package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionSummarizeBody(
    @JsonProperty("providerID") String providerID,
    @JsonProperty("modelID") String modelID,
    @JsonProperty("auto") Boolean auto
) {
}
