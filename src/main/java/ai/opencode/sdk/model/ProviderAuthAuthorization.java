package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商认证授权数据模型。
 *
 * @param url 可访问的地址。
 * @param method 方法。
 * @param instructions 操作说明。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderAuthAuthorization(
    @JsonProperty("url") String url,
    @JsonProperty("method") String method,
    @JsonProperty("instructions") String instructions) {}
