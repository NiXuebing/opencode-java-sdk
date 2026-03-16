package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTuiPromptAppend(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventTuiPromptAppendProperties properties
) implements Event, TuiPublishBody {
}
