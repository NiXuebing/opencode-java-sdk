package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StepFinishPartTokens(
    @JsonProperty("total") Double total,
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("reasoning") Double reasoning,
    @JsonProperty("cache") StepFinishPartTokensCache cache
) {
}
