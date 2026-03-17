package ai.opencode.sdk.request;

import ai.opencode.sdk.model.TuiExecuteCommandBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiExecuteCommandRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("body") TuiExecuteCommandBody body) {}
