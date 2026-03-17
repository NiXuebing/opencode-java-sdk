package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRespondRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("permissionID") String permissionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") PermissionRespondBody body) {}
