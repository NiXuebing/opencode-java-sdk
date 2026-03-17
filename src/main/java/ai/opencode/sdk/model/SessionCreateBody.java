package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCreateBody(
    @JsonProperty("parentID") String parentID,
    @JsonProperty("title") String title,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("workspaceID") String workspaceID) {}
