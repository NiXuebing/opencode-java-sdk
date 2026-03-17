package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigFormatter2Value(
    @JsonProperty("disabled") Boolean disabled,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("extensions") List<String> extensions) {}
