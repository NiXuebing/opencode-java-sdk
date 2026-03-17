package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

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
