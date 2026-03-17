package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilePartSourceText(
    @JsonProperty("value") String value,
    @JsonProperty("start") Long start,
    @JsonProperty("end") Long end) {}
