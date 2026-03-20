package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 会话错误事件中的错误联合类型。
 * 实际实现类型由 name 字段判别。
 */
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
public interface EventSessionErrorPropertiesError {
}
