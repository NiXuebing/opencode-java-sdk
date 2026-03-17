package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResourceSource(
    @JsonProperty("text") FilePartSourceText text,
    @JsonProperty("type") String type,
    @JsonProperty("clientName") String clientName,
    @JsonProperty("uri") String uri)
    implements FilePartSource {}
