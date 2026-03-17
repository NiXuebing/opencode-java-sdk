package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProjectIcon(
    @JsonProperty("url") String url,
    @JsonProperty("override") String override,
    @JsonProperty("color") String color) {}
