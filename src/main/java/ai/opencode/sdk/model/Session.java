package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Session(
    @JsonProperty("id") String id,
    @JsonProperty("slug") String slug,
    @JsonProperty("projectID") String projectID,
    @JsonProperty("directory") String directory,
    @JsonProperty("parentID") String parentID,
    @JsonProperty("summary") SessionSummary summary,
    @JsonProperty("share") SessionShare share,
    @JsonProperty("title") String title,
    @JsonProperty("version") String version,
    @JsonProperty("time") SessionTime time,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("revert") SessionRevert revert
) {
}
