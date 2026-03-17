package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("roots") Boolean roots,
    @JsonProperty("start") Double start,
    @JsonProperty("search") String search,
    @JsonProperty("limit") Double limit) {}
