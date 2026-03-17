package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindSymbolsRequest(
    @JsonProperty("directory") String directory, @JsonProperty("query") String query) {}
