package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record APIErrorData(
    @JsonProperty("message") String message,
    @JsonProperty("statusCode") Double statusCode,
    @JsonProperty("isRetryable") Boolean isRetryable,
    @JsonProperty("responseHeaders") Map<String, String> responseHeaders,
    @JsonProperty("responseBody") String responseBody,
    @JsonProperty("metadata") Map<String, String> metadata
) {
}
