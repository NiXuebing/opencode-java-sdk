package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Agent(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("mode") String mode,
    @JsonProperty("native") Boolean nativeValue,
    @JsonProperty("hidden") Boolean hidden,
    @JsonProperty("topP") Double topP,
    @JsonProperty("temperature") Double temperature,
    @JsonProperty("color") String color,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("model") AgentModel model,
    @JsonProperty("variant") String variant,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("steps") Long steps
) {
}
