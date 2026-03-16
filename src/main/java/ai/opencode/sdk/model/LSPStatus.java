package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record LSPStatus(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("root") String root,
    @JsonProperty("status") String status
) {
}
