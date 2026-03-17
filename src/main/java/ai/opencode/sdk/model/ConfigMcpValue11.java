package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigMcpValue11(
    @JsonProperty("type") String type,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("timeout") Long timeout) {}
