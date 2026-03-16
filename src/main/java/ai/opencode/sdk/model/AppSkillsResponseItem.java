package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppSkillsResponseItem(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("location") String location,
    @JsonProperty("content") String content
) {
}
