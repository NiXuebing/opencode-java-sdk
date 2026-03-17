package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponse(
    @JsonProperty("all") List<ProviderListResponseAllItem> all,
    @JsonProperty("default") Map<String, String> defaultValue,
    @JsonProperty("connected") List<String> connected) {}
