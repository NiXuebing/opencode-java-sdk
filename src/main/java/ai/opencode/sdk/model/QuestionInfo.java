package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionInfo(
    @JsonProperty("question") String question,
    @JsonProperty("header") String header,
    @JsonProperty("options") List<QuestionOption> options,
    @JsonProperty("multiple") Boolean multiple,
    @JsonProperty("custom") Boolean custom) {}
