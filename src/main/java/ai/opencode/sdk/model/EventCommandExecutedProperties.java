package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventCommandExecutedProperties(
    @JsonProperty("name") String name,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("arguments") String arguments,
    @JsonProperty("messageID") String messageID
) {
}
