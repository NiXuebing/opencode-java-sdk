package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionRevert(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("partID") String partID,
    @JsonProperty("snapshot") String snapshot,
    @JsonProperty("diff") String diff
) {
}
