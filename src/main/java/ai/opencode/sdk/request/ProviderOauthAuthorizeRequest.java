package ai.opencode.sdk.request;

import ai.opencode.sdk.model.ProviderOauthAuthorizeBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderOauthAuthorizeRequest(
    @JsonProperty("providerID") String providerID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") ProviderOauthAuthorizeBody body) {}
