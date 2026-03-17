package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = McpLocalConfig.class, name = "local"),
  @JsonSubTypes.Type(value = McpRemoteConfig.class, name = "remote")
})
public sealed interface McpAddBodyConfig permits McpLocalConfig, McpRemoteConfig {}
