package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商OAuth回调请求体。
 *
 * @param method method。
 * @param code 授权码或标识代码。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderOauthCallbackBody(
    @JsonProperty("method") Double method, @JsonProperty("code") String code) {}
