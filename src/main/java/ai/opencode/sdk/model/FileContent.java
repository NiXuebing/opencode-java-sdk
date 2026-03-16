package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContent(
    @JsonProperty("type") String type,
    @JsonProperty("content") String content,
    @JsonProperty("diff") String diff,
    @JsonProperty("patch") FileContentPatch patch,
    @JsonProperty("encoding") String encoding,
    @JsonProperty("mimeType") String mimeType
) {
}
