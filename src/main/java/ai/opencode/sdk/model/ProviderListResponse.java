package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponse(
    @JsonProperty("all") List<ProviderListResponseAllItem> all,
    @JsonProperty("default") Map<String, String> defaultValue,
    @JsonProperty("connected") List<String> connected) {}
