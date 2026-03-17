package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("provider") String provider,
    @JsonProperty("model") String model) {}
