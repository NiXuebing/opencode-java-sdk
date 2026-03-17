package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("provider") String provider,
    @JsonProperty("model") String model) {}
