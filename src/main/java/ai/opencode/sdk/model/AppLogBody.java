package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppLogBody(
    @JsonProperty("service") String service,
    @JsonProperty("level") String level,
    @JsonProperty("message") String message,
    @JsonProperty("extra") Map<String, JsonNode> extra) {}
