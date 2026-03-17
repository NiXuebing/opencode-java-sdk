package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionInitBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionInitRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionInitBody body) {}
