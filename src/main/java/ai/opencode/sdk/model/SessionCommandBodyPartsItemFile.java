package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCommandBodyPartsItemFile(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("mime") String mime,
    @JsonProperty("filename") String filename,
    @JsonProperty("url") String url,
    @JsonProperty("source") FilePartSource source
) implements SessionCommandBodyPartsItem {
}
