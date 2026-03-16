package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record WellKnownAuth(
    @JsonProperty("type") String type,
    @JsonProperty("key") String key,
    @JsonProperty("token") String token
) implements Auth {
}
