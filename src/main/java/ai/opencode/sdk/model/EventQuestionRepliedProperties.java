package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventQuestionRepliedProperties(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("requestID") String requestID,
    @JsonProperty("answers") List<QuestionAnswer> answers) {}
