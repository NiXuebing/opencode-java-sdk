package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionRequest(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("questions") List<QuestionInfo> questions,
    @JsonProperty("tool") QuestionRequestTool tool
) {
}
