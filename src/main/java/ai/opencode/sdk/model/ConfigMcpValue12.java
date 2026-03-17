package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigMcpValue12(
    @JsonProperty("type") String type,
    @JsonProperty("url") String url,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("oauth") JsonNode oauth,
    @JsonProperty("timeout") Long timeout) {}
