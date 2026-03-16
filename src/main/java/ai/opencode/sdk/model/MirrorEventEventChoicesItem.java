package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MirrorEventEventChoicesItem(
    @JsonProperty("delta") MirrorEventEventChoicesItemDelta delta,
    @JsonProperty("finish_reason") JsonNode finishReason,
    @JsonProperty("index") Double index,
    @JsonProperty("logprobs") JsonNode logprobs
) {
}
