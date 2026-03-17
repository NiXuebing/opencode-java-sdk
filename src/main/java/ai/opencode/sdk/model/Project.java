package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Project(
    @JsonProperty("id") String id,
    @JsonProperty("worktree") String worktree,
    @JsonProperty("vcs") String vcs,
    @JsonProperty("name") String name,
    @JsonProperty("icon") ProjectIcon icon,
    @JsonProperty("commands") ProjectCommands commands,
    @JsonProperty("time") ProjectTime time,
    @JsonProperty("sandboxes") List<String> sandboxes) {}
