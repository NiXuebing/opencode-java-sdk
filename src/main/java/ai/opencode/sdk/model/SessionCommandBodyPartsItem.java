package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SessionCommandBodyPartsItemFile.class, name = "file")
})
public sealed interface SessionCommandBodyPartsItem permits SessionCommandBodyPartsItemFile {
}
