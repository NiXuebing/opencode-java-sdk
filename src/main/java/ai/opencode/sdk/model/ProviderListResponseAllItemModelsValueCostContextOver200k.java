package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueCostContextOver200k(
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("cache_read") Double cacheRead,
    @JsonProperty("cache_write") Double cacheWrite) {}
