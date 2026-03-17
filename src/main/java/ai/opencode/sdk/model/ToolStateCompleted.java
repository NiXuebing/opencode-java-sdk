package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolStateCompleted(
    @JsonProperty("status") String status,
    @JsonProperty("input") Map<String, JsonNode> input,
    @JsonProperty("output") String output,
    @JsonProperty("title") String title,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("time") ToolStateCompletedTime time,
    @JsonProperty("attachments") List<FilePart> attachments)
    implements ToolState {}
