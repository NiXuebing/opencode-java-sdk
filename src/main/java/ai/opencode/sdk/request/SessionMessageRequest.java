package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionMessageRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("directory") String directory) {}
