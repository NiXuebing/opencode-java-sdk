package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionSummary(
    @JsonProperty("additions") Double additions,
    @JsonProperty("deletions") Double deletions,
    @JsonProperty("files") Double files,
    @JsonProperty("diffs") List<FileDiff> diffs
) {
}
