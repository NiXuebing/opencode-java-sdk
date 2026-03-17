package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventLspClientDiagnosticsProperties(
    @JsonProperty("serverID") String serverID, @JsonProperty("path") String path) {}
