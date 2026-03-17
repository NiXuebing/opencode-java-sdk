package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Session(
    @JsonProperty("id") String id,
    @JsonProperty("slug") String slug,
    @JsonProperty("projectID") String projectID,
    @JsonProperty("workspaceID") String workspaceID,
    @JsonProperty("directory") String directory,
    @JsonProperty("parentID") String parentID,
    @JsonProperty("summary") SessionSummary summary,
    @JsonProperty("share") SessionShare share,
    @JsonProperty("title") String title,
    @JsonProperty("version") String version,
    @JsonProperty("time") SessionTime time,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("revert") SessionRevert revert) {}
