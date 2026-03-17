package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventSessionUpdated(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventSessionUpdatedProperties properties)
    implements Event {}
