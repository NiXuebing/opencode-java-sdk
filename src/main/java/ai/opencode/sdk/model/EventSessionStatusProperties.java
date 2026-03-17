package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventSessionStatusProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("status") SessionStatus status) {}
