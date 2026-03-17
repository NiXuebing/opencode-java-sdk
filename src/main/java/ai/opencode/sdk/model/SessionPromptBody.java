package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("model") SessionPromptBodyModel model,
    @JsonProperty("agent") String agent,
    @JsonProperty("noReply") Boolean noReply,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("format") OutputFormat format,
    @JsonProperty("system") String system,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionPromptBodyPartsItem> parts) {}
