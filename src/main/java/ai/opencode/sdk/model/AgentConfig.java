package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentConfig(
    @JsonProperty("model") String model,
    @JsonProperty("variant") String variant,
    @JsonProperty("temperature") Double temperature,
    @JsonProperty("top_p") Double topP,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("disable") Boolean disable,
    @JsonProperty("description") String description,
    @JsonProperty("mode") String mode,
    @JsonProperty("hidden") Boolean hidden,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("color") String color,
    @JsonProperty("steps") Long steps,
    @JsonProperty("maxSteps") Long maxSteps,
    @JsonProperty("permission") PermissionConfig permission) {}
