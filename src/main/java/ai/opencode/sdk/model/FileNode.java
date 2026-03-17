package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileNode(
    @JsonProperty("name") String name,
    @JsonProperty("path") String path,
    @JsonProperty("absolute") String absolute,
    @JsonProperty("type") String type,
    @JsonProperty("ignored") Boolean ignored) {}
