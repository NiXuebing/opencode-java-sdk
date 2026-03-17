package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValue(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("family") String family,
    @JsonProperty("release_date") String releaseDate,
    @JsonProperty("attachment") Boolean attachment,
    @JsonProperty("reasoning") Boolean reasoning,
    @JsonProperty("temperature") Boolean temperature,
    @JsonProperty("tool_call") Boolean toolCall,
    @JsonProperty("interleaved") JsonNode interleaved,
    @JsonProperty("cost") ProviderListResponseAllItemModelsValueCost cost,
    @JsonProperty("limit") ProviderListResponseAllItemModelsValueLimit limit,
    @JsonProperty("modalities") ProviderListResponseAllItemModelsValueModalities modalities,
    @JsonProperty("experimental") Boolean experimental,
    @JsonProperty("status") String status,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("provider") ProviderListResponseAllItemModelsValueProvider provider,
    @JsonProperty("variants") Map<String, Map<String, JsonNode>> variants) {}
