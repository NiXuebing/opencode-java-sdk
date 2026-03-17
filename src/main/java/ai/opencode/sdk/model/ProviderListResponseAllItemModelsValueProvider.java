package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueProvider(
    @JsonProperty("npm") String npm, @JsonProperty("api") String api) {}
