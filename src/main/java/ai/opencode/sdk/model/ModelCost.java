package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCost(
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("cache") ModelCostCache cache,
    @JsonProperty("experimentalOver200K") ModelCostExperimentalOver200K experimentalOver200K
) {
}
