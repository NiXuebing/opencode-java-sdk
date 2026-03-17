package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventFileEdited(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventFileEditedProperties properties)
    implements Event {}
