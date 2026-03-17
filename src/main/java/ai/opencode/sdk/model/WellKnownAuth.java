package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Well Known认证数据模型。
 *
 * @param type 类型标识。
 * @param key 密钥。
 * @param token 令牌。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record WellKnownAuth(
    @JsonProperty("type") String type,
    @JsonProperty("key") String key,
    @JsonProperty("token") String token)
    implements Auth {}
