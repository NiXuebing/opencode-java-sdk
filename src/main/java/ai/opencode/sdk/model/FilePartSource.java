package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FileSource.class, name = "file"),
  @JsonSubTypes.Type(value = SymbolSource.class, name = "symbol"),
  @JsonSubTypes.Type(value = ResourceSource.class, name = "resource")
})
public sealed interface FilePartSource permits FileSource, SymbolSource, ResourceSource {}
