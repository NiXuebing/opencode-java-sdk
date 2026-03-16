package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PartDeleteRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("partID") String partID,
    @JsonProperty("directory") String directory
) {
}
