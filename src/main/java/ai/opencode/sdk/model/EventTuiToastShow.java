package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTuiToastShow(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventTuiToastShowProperties properties)
    implements Event {}
