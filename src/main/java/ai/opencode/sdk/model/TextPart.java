package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TextPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("text") String text,
    @JsonProperty("synthetic") Boolean synthetic,
    @JsonProperty("ignored") Boolean ignored,
    @JsonProperty("time") TextPartTime time,
    @JsonProperty("metadata") Map<String, JsonNode> metadata)
    implements Part {}
