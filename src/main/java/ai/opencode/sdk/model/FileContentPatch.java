package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContentPatch(
    @JsonProperty("oldFileName") String oldFileName,
    @JsonProperty("newFileName") String newFileName,
    @JsonProperty("oldHeader") String oldHeader,
    @JsonProperty("newHeader") String newHeader,
    @JsonProperty("hunks") List<FileContentPatchHunksItem> hunks,
    @JsonProperty("index") String index
) {
}
