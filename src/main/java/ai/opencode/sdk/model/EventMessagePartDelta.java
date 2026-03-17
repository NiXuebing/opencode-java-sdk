package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventMessagePartDelta(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventMessagePartDeltaProperties properties)
    implements Event {}
