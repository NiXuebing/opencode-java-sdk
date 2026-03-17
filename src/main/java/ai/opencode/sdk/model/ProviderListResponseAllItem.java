package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItem(
    @JsonProperty("api") String api,
    @JsonProperty("name") String name,
    @JsonProperty("env") List<String> env,
    @JsonProperty("id") String id,
    @JsonProperty("npm") String npm,
    @JsonProperty("models") Map<String, ProviderListResponseAllItemModelsValue> models) {}
