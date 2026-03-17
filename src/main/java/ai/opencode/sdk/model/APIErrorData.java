package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record APIErrorData(
    @JsonProperty("message") String message,
    @JsonProperty("statusCode") Double statusCode,
    @JsonProperty("isRetryable") Boolean isRetryable,
    @JsonProperty("responseHeaders") Map<String, String> responseHeaders,
    @JsonProperty("responseBody") String responseBody,
    @JsonProperty("metadata") Map<String, String> metadata) {}
