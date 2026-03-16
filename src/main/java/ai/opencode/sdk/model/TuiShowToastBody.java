package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiShowToastBody(
    @JsonProperty("title") String title,
    @JsonProperty("message") String message,
    @JsonProperty("variant") String variant,
    @JsonProperty("duration") Double duration
) {
}
