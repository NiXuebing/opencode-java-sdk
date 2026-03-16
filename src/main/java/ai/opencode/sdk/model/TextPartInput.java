package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TextPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("text") String text,
    @JsonProperty("synthetic") Boolean synthetic,
    @JsonProperty("ignored") Boolean ignored,
    @JsonProperty("time") TextPartInputTime time,
    @JsonProperty("metadata") Map<String, JsonNode> metadata
) implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {
}
