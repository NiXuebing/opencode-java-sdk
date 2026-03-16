package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileDiff(
    @JsonProperty("file") String file,
    @JsonProperty("before") String before,
    @JsonProperty("after") String after,
    @JsonProperty("additions") Double additions,
    @JsonProperty("deletions") Double deletions,
    @JsonProperty("status") String status
) {
}
