package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRule(
    @JsonProperty("permission") String permission,
    @JsonProperty("pattern") String pattern,
    @JsonProperty("action") PermissionAction action) {}
