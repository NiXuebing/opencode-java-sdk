package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionStatusRetry(
    @JsonProperty("type") String type,
    @JsonProperty("attempt") Double attempt,
    @JsonProperty("message") String message,
    @JsonProperty("next") Double next)
    implements SessionStatus {}
