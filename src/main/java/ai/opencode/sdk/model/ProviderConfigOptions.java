package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderConfigOptions(
    @JsonProperty("apiKey") String apiKey,
    @JsonProperty("baseURL") String baseURL,
    @JsonProperty("enterpriseUrl") String enterpriseUrl,
    @JsonProperty("setCacheKey") Boolean setCacheKey,
    @JsonProperty("timeout") JsonNode timeout
) {
}
