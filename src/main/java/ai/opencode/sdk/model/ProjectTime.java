package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProjectTime(
    @JsonProperty("created") Double created,
    @JsonProperty("updated") Double updated,
    @JsonProperty("initialized") Double initialized) {}
