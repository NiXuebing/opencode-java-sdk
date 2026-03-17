package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PatchPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("hash") String hash,
    @JsonProperty("files") List<String> files)
    implements Part {}
