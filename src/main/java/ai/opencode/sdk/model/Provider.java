package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Provider(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("source") String source,
    @JsonProperty("env") List<String> env,
    @JsonProperty("key") String key,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("models") Map<String, Model> models) {}
