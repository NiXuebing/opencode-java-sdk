package ai.opencode.sdk.request;

import ai.opencode.sdk.model.ProviderOauthAuthorizeBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 发起提供商 OAuth 授权接口请求参数。
 *
 * @param providerID 目标提供商 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 发起提供商 OAuth 授权的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderOauthAuthorizeRequest(
    @JsonProperty("providerID") String providerID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") ProviderOauthAuthorizeBody body) {}
