package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserMessage(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("role") String role,
    @JsonProperty("time") UserMessageTime time,
    @JsonProperty("format") OutputFormat format,
    @JsonProperty("summary") UserMessageSummary summary,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") UserMessageModel model,
    @JsonProperty("system") String system,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("variant") String variant)
    implements Message {}
