package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelApi(
    @JsonProperty("id") String id,
    @JsonProperty("url") String url,
    @JsonProperty("npm") String npm) {}
