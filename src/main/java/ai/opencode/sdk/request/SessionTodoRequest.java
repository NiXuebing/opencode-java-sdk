package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionTodoRequest(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("directory") String directory) {}
