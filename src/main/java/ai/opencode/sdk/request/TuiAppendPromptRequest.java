package ai.opencode.sdk.request;

import ai.opencode.sdk.model.TuiAppendPromptBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiAppendPromptRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") TuiAppendPromptBody body) {}
