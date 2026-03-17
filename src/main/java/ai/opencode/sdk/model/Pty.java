package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Pty(
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("command") String command,
    @JsonProperty("args") List<String> args,
    @JsonProperty("cwd") String cwd,
    @JsonProperty("status") String status,
    @JsonProperty("pid") Double pid) {}
