package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventQuestionRepliedProperties(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("requestID") String requestID,
    @JsonProperty("answers") List<QuestionAnswer> answers) {}
