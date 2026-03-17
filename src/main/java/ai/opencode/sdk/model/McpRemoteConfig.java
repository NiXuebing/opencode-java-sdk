package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpRemoteConfig(
    @JsonProperty("type") String type,
    @JsonProperty("url") String url,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("oauth") JsonNode oauth,
    @JsonProperty("timeout") Long timeout)
    implements McpAddBodyConfig {}
