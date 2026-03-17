package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindTextResponseItem(
    @JsonProperty("path") FindTextResponseItemPath path,
    @JsonProperty("lines") FindTextResponseItemLines lines,
    @JsonProperty("line_number") Double lineNumber,
    @JsonProperty("absolute_offset") Double absoluteOffset,
    @JsonProperty("submatches") List<FindTextResponseItemSubmatchesItem> submatches) {}
