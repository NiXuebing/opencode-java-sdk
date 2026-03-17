package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderConfigOptions(
    @JsonProperty("apiKey") String apiKey,
    @JsonProperty("baseURL") String baseURL,
    @JsonProperty("enterpriseUrl") String enterpriseUrl,
    @JsonProperty("setCacheKey") Boolean setCacheKey,
    @JsonProperty("timeout") JsonNode timeout,
    @JsonProperty("chunkTimeout") Long chunkTimeout) {}
