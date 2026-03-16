package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "status", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MCPStatusConnected.class, name = "connected"),
    @JsonSubTypes.Type(value = MCPStatusDisabled.class, name = "disabled"),
    @JsonSubTypes.Type(value = MCPStatusFailed.class, name = "failed"),
    @JsonSubTypes.Type(value = MCPStatusNeedsAuth.class, name = "needs_auth"),
    @JsonSubTypes.Type(value = MCPStatusNeedsClientRegistration.class, name = "needs_client_registration")
})
public sealed interface MCPStatus permits MCPStatusConnected, MCPStatusDisabled, MCPStatusFailed, MCPStatusNeedsAuth, MCPStatusNeedsClientRegistration {
}
