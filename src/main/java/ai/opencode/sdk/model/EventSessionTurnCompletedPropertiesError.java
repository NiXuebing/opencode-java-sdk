package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "name", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ProviderAuthError.class, name = "ProviderAuthError"),
    @JsonSubTypes.Type(value = UnknownError.class, name = "UnknownError"),
    @JsonSubTypes.Type(value = MessageOutputLengthError.class, name = "MessageOutputLengthError"),
    @JsonSubTypes.Type(value = MessageAbortedError.class, name = "MessageAbortedError"),
    @JsonSubTypes.Type(value = StructuredOutputError.class, name = "StructuredOutputError"),
    @JsonSubTypes.Type(value = ContextOverflowError.class, name = "ContextOverflowError"),
    @JsonSubTypes.Type(value = APIError.class, name = "APIError")
})
public sealed interface EventSessionTurnCompletedPropertiesError permits ProviderAuthError, UnknownError, MessageOutputLengthError, MessageAbortedError, StructuredOutputError, ContextOverflowError, APIError {
}
