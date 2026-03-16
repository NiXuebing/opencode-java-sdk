package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionInitRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionInitBody body
) {
}
