package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PtyCreateBody(
    @JsonProperty("command") String command,
    @JsonProperty("args") List<String> args,
    @JsonProperty("cwd") String cwd,
    @JsonProperty("title") String title,
    @JsonProperty("env") Map<String, String> env
) {
}
