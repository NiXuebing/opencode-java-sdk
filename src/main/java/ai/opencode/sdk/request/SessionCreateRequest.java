package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionCreateBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCreateRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") SessionCreateBody body) {}
