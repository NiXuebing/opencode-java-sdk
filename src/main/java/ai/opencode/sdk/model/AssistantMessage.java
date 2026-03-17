package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessage(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("role") String role,
    @JsonProperty("time") AssistantMessageTime time,
    @JsonProperty("error") AssistantMessageError error,
    @JsonProperty("parentID") String parentID,
    @JsonProperty("modelID") String modelID,
    @JsonProperty("providerID") String providerID,
    @JsonProperty("mode") String mode,
    @JsonProperty("agent") String agent,
    @JsonProperty("path") AssistantMessagePath path,
    @JsonProperty("summary") Boolean summary,
    @JsonProperty("cost") Double cost,
    @JsonProperty("tokens") AssistantMessageTokens tokens,
    @JsonProperty("structured") JsonNode structured,
    @JsonProperty("variant") String variant,
    @JsonProperty("finish") String finish)
    implements Message {}
