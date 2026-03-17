package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventMcpBrowserOpenFailedProperties(
    @JsonProperty("mcpName") String mcpName, @JsonProperty("url") String url) {}
