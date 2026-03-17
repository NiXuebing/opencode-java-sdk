package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Command(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("source") String source,
    @JsonProperty("template") String template,
    @JsonProperty("subtask") Boolean subtask,
    @JsonProperty("hints") List<String> hints) {}
