package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResourceSource(
    @JsonProperty("text") FilePartSourceText text,
    @JsonProperty("type") String type,
    @JsonProperty("clientName") String clientName,
    @JsonProperty("uri") String uri)
    implements FilePartSource {}
