package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigProvidersResponse(
    @JsonProperty("providers") List<Provider> providers,
    @JsonProperty("default") Map<String, String> defaultValue) {}
