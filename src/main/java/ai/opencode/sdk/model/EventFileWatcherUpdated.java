package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventFileWatcherUpdated(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventFileWatcherUpdatedProperties properties)
    implements Event {}
