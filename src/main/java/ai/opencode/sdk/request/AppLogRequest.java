package ai.opencode.sdk.request;

import ai.opencode.sdk.model.AppLogBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppLogRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") AppLogBody body) {}
