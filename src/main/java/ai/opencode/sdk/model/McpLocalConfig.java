package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpLocalConfig(
    @JsonProperty("type") String type,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("timeout") Long timeout
) implements McpAddBodyConfig {
}
