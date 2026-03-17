package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StepFinishPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("reason") String reason,
    @JsonProperty("snapshot") String snapshot,
    @JsonProperty("cost") Double cost,
    @JsonProperty("tokens") StepFinishPartTokens tokens)
    implements Part {}
