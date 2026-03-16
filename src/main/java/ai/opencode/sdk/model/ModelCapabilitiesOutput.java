package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilitiesOutput(
    @JsonProperty("text") Boolean text,
    @JsonProperty("audio") Boolean audio,
    @JsonProperty("image") Boolean image,
    @JsonProperty("video") Boolean video,
    @JsonProperty("pdf") Boolean pdf
) {
}
