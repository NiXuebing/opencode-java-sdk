package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MirrorEventEvent(
    @JsonProperty("id") String id,
    @JsonProperty("choices") List<MirrorEventEventChoicesItem> choices,
    @JsonProperty("created") Double created,
    @JsonProperty("model") String model,
    @JsonProperty("object") String object,
    @JsonProperty("service_tier") JsonNode serviceTier,
    @JsonProperty("system_fingerprint") JsonNode systemFingerprint,
    @JsonProperty("usage") JsonNode usage
) {
}
