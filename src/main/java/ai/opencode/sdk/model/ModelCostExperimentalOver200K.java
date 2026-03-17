package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCostExperimentalOver200K(
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("cache") ModelCostExperimentalOver200KCache cache) {}
