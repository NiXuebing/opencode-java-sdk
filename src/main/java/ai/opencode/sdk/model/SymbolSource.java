package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SymbolSource(
    @JsonProperty("text") FilePartSourceText text,
    @JsonProperty("type") String type,
    @JsonProperty("path") String path,
    @JsonProperty("range") Range range,
    @JsonProperty("name") String name,
    @JsonProperty("kind") Long kind)
    implements FilePartSource {}
