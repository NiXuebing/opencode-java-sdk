package ai.opencode.sdk.request;

import ai.opencode.sdk.model.TuiShowToastBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiShowToastRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") TuiShowToastBody body) {}
