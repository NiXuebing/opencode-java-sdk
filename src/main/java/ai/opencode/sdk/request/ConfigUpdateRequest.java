package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigUpdateRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") Config body) {}
