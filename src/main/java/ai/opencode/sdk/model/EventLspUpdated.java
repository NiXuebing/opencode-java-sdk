package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventLspUpdated(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventLspUpdatedProperties properties)
    implements Event {}
