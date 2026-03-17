package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("name") String name,
    @JsonProperty("source") AgentPartInputSource source)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
