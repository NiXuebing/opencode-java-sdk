package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionRevertBody(
    @JsonProperty("messageID") String messageID, @JsonProperty("partID") String partID) {}
