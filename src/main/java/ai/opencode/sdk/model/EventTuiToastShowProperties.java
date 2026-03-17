package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTuiToastShowProperties(
    @JsonProperty("title") String title,
    @JsonProperty("message") String message,
    @JsonProperty("variant") String variant,
    @JsonProperty("duration") Double duration) {}
