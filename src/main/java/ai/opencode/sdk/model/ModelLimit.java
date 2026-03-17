package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelLimit(
    @JsonProperty("context") Double context,
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output) {}
