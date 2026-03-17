package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StructuredOutputError(
    @JsonProperty("name") String name, @JsonProperty("data") StructuredOutputErrorData data)
    implements AssistantMessageError, EventSessionErrorPropertiesError {}
