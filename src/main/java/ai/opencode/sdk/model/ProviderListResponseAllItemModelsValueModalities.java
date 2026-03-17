package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueModalities(
    @JsonProperty("input") List<String> input, @JsonProperty("output") List<String> output) {}
