package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCommandRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionCommandBody body) {}
