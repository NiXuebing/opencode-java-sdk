package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigTui(
    @JsonProperty("scroll_speed") Double scrollSpeed,
    @JsonProperty("scroll_acceleration") ConfigTuiScrollAcceleration scrollAcceleration,
    @JsonProperty("diff_style") String diffStyle
) {
}
