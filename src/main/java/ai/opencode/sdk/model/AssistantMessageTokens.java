package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessageTokens(
    @JsonProperty("total") Double total,
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("reasoning") Double reasoning,
    @JsonProperty("cache") AssistantMessageTokensCache cache) {}
