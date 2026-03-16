package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCommandBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("arguments") String arguments,
    @JsonProperty("command") String command,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionCommandBodyPartsItem> parts
) {
}
