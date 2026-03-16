package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OutputFormatText.class, name = "text"),
    @JsonSubTypes.Type(value = OutputFormatJsonSchema.class, name = "json_schema")
})
public sealed interface OutputFormat permits OutputFormatText, OutputFormatJsonSchema {
}
