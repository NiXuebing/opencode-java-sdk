package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigAgent(
    @JsonProperty("plan") AgentConfig plan,
    @JsonProperty("build") AgentConfig build,
    @JsonProperty("general") AgentConfig general,
    @JsonProperty("explore") AgentConfig explore,
    @JsonProperty("title") AgentConfig title,
    @JsonProperty("summary") AgentConfig summary,
    @JsonProperty("compaction") AgentConfig compaction) {}
