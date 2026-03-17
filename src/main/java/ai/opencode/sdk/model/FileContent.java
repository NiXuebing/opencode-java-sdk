package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContent(
    @JsonProperty("type") String type,
    @JsonProperty("content") String content,
    @JsonProperty("diff") String diff,
    @JsonProperty("patch") FileContentPatch patch,
    @JsonProperty("encoding") String encoding,
    @JsonProperty("mimeType") String mimeType) {}
