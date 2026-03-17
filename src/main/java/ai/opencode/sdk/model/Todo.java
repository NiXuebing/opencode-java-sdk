package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Todo(
    @JsonProperty("content") String content,
    @JsonProperty("status") String status,
    @JsonProperty("priority") String priority) {}
