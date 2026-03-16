package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Path(
    @JsonProperty("home") String home,
    @JsonProperty("state") String state,
    @JsonProperty("config") String config,
    @JsonProperty("worktree") String worktree,
    @JsonProperty("directory") String directory
) {
}
