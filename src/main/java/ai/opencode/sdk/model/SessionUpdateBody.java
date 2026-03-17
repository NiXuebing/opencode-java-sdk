package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionUpdateBody(
    @JsonProperty("title") String title, @JsonProperty("time") SessionUpdateBodyTime time) {}
