package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventWorktreeReadyProperties(
    @JsonProperty("name") String name, @JsonProperty("branch") String branch) {}
