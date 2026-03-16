package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigLsp2Value2(
    @JsonProperty("command") List<String> command,
    @JsonProperty("extensions") List<String> extensions,
    @JsonProperty("disabled") Boolean disabled,
    @JsonProperty("env") Map<String, String> env,
    @JsonProperty("initialization") Map<String, JsonNode> initialization
) {
}
