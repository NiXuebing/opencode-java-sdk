package ai.opencode.sdk.request;

import ai.opencode.sdk.model.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("roots") Boolean roots,
    @JsonProperty("start") Double start,
    @JsonProperty("search") String search,
    @JsonProperty("limit") Double limit) {}
