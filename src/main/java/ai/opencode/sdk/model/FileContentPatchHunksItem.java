package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContentPatchHunksItem(
    @JsonProperty("oldStart") Double oldStart,
    @JsonProperty("oldLines") Double oldLines,
    @JsonProperty("newStart") Double newStart,
    @JsonProperty("newLines") Double newLines,
    @JsonProperty("lines") List<String> lines
) {
}
