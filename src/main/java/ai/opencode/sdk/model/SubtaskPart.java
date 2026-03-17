package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubtaskPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SubtaskPartModel model,
    @JsonProperty("command") String command)
    implements Part {}
