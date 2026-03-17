package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigFormatter2Value(
    @JsonProperty("disabled") Boolean disabled,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("extensions") List<String> extensions) {}
