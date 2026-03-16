package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigCommandValue(
    @JsonProperty("template") String template,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("subtask") Boolean subtask
) {
}
