package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpResource(
    @JsonProperty("name") String name,
    @JsonProperty("uri") String uri,
    @JsonProperty("description") String description,
    @JsonProperty("mimeType") String mimeType,
    @JsonProperty("client") String client
) {
}
