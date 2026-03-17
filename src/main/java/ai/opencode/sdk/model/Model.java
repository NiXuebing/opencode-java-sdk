package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Model(
    @JsonProperty("id") String id,
    @JsonProperty("providerID") String providerID,
    @JsonProperty("api") ModelApi api,
    @JsonProperty("name") String name,
    @JsonProperty("family") String family,
    @JsonProperty("capabilities") ModelCapabilities capabilities,
    @JsonProperty("cost") ModelCost cost,
    @JsonProperty("limit") ModelLimit limit,
    @JsonProperty("status") String status,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("release_date") String releaseDate,
    @JsonProperty("variants") Map<String, Map<String, JsonNode>> variants) {}
