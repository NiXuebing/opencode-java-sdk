package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "role", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = UserMessage.class, name = "user"),
    @JsonSubTypes.Type(value = AssistantMessage.class, name = "assistant")
})
public sealed interface Message permits UserMessage, AssistantMessage {
}
