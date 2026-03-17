package ai.opencode.sdk.request;

import ai.opencode.sdk.model.Auth;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 设置提供商认证接口请求参数。
 *
 * @param providerID 目标提供商 ID。
 * @param body 设置提供商认证的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthSetRequest(
    @JsonProperty("providerID") String providerID, @JsonProperty("body") Auth body) {}
