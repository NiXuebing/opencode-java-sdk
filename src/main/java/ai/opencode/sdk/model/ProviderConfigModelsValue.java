package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderConfigModelsValue(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("family") String family,
    @JsonProperty("release_date") String releaseDate,
    @JsonProperty("attachment") Boolean attachment,
    @JsonProperty("reasoning") Boolean reasoning,
    @JsonProperty("temperature") Boolean temperature,
    @JsonProperty("tool_call") Boolean toolCall,
    @JsonProperty("interleaved") JsonNode interleaved,
    @JsonProperty("cost") ProviderConfigModelsValueCost cost,
    @JsonProperty("limit") ProviderConfigModelsValueLimit limit,
    @JsonProperty("modalities") ProviderConfigModelsValueModalities modalities,
    @JsonProperty("experimental") Boolean experimental,
    @JsonProperty("status") String status,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("provider") ProviderConfigModelsValueProvider provider,
    @JsonProperty("variants") Map<String, ProviderConfigModelsValueVariantsValue> variants) {}
