package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UnknownError(
    @JsonProperty("name") String name, @JsonProperty("data") UnknownErrorData data)
    implements AssistantMessageError, EventSessionErrorPropertiesError {}
