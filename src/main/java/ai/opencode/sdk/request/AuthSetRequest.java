package ai.opencode.sdk.request;

import ai.opencode.sdk.model.Auth;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthSetRequest(
    @JsonProperty("providerID") String providerID, @JsonProperty("body") Auth body) {}
