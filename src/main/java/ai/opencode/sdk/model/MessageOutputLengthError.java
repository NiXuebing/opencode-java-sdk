package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MessageOutputLengthError(
    @JsonProperty("name") String name,
    @JsonProperty("data") MessageOutputLengthErrorData data
) implements AssistantMessageError, EventSessionErrorPropertiesError, EventSessionTurnCompletedPropertiesError {
}
