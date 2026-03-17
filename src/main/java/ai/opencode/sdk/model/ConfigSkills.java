package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigSkills(
    @JsonProperty("paths") List<String> paths, @JsonProperty("urls") List<String> urls) {}
