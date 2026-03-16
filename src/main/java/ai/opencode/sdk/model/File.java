package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record File(
    @JsonProperty("path") String path,
    @JsonProperty("added") Long added,
    @JsonProperty("removed") Long removed,
    @JsonProperty("status") String status
) {
}
