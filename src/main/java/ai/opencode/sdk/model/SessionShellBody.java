package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionShellBody(
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SessionShellBodyModel model,
    @JsonProperty("command") String command) {}
