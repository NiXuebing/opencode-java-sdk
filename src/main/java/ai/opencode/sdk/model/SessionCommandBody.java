package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCommandBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("arguments") String arguments,
    @JsonProperty("command") String command,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionCommandBodyPartsItem> parts) {}
