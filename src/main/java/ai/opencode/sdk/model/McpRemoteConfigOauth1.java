package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpRemoteConfigOauth1(
    @JsonProperty("clientId") String clientId,
    @JsonProperty("clientSecret") String clientSecret,
    @JsonProperty("scope") String scope) {}
