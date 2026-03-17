package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** MCP状态联合类型。 实际实现类型由 status 字段判别。 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "status",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = MCPStatusConnected.class, name = "connected"),
  @JsonSubTypes.Type(value = MCPStatusDisabled.class, name = "disabled"),
  @JsonSubTypes.Type(value = MCPStatusFailed.class, name = "failed"),
  @JsonSubTypes.Type(value = MCPStatusNeedsAuth.class, name = "needs_auth"),
  @JsonSubTypes.Type(
      value = MCPStatusNeedsClientRegistration.class,
      name = "needs_client_registration")
})
public sealed interface MCPStatus
    permits MCPStatusConnected,
        MCPStatusDisabled,
        MCPStatusFailed,
        MCPStatusNeedsAuth,
        MCPStatusNeedsClientRegistration {}
