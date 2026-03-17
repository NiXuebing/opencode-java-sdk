package ai.opencode.sdk.request;

import ai.opencode.sdk.model.ProviderOauthCallbackBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 处理提供商 OAuth 回调接口的请求参数。
 *
 * @param providerID 目标提供商 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 处理提供商 OAuth 回调对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderOauthCallbackRequest(
    @JsonProperty("providerID") String providerID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") ProviderOauthCallbackBody body) {}
