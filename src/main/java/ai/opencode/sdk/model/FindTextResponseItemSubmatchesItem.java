package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindTextResponseItemSubmatchesItem(
    @JsonProperty("match") FindTextResponseItemSubmatchesItemMatch match,
    @JsonProperty("start") Double start,
    @JsonProperty("end") Double end) {}
