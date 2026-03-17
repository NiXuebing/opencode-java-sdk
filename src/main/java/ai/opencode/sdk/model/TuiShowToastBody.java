package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiShowToastBody(
    @JsonProperty("title") String title,
    @JsonProperty("message") String message,
    @JsonProperty("variant") String variant,
    @JsonProperty("duration") Double duration) {}
