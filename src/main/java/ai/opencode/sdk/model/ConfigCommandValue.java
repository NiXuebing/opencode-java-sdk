package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigCommandValue(
    @JsonProperty("template") String template,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("subtask") Boolean subtask) {}
