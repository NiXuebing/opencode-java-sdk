package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("provider") String provider,
    @JsonProperty("model") String model
) {
}
