package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilitiesOutput(
    @JsonProperty("text") Boolean text,
    @JsonProperty("audio") Boolean audio,
    @JsonProperty("image") Boolean image,
    @JsonProperty("video") Boolean video,
    @JsonProperty("pdf") Boolean pdf) {}
