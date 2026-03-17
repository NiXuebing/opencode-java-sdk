package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FormatterStatus(
    @JsonProperty("name") String name,
    @JsonProperty("extensions") List<String> extensions,
    @JsonProperty("enabled") Boolean enabled) {}
