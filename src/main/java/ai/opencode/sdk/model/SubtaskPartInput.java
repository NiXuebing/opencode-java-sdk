package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubtaskPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SubtaskPartInputModel model,
    @JsonProperty("command") String command)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
