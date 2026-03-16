package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BadRequestError(
    @JsonProperty("data") JsonNode data,
    @JsonProperty("errors") List<Map<String, JsonNode>> errors,
    @JsonProperty("success") Boolean success
) {
}
