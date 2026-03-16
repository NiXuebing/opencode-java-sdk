package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptAsyncBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("model") SessionPromptAsyncBodyModel model,
    @JsonProperty("agent") String agent,
    @JsonProperty("noReply") Boolean noReply,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("format") OutputFormat format,
    @JsonProperty("system") String system,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionPromptAsyncBodyPartsItem> parts
) {
}
