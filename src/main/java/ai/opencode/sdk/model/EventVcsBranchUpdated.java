package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventVcsBranchUpdated(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventVcsBranchUpdatedProperties properties)
    implements Event {}
