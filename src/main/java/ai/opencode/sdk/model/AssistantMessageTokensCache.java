package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessageTokensCache(
    @JsonProperty("read") Double read, @JsonProperty("write") Double write) {}
