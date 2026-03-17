package ai.opencode.sdk.request;

import ai.opencode.sdk.model.McpAddBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpAddRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") McpAddBody body) {}
