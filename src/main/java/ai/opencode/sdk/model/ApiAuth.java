package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * API认证数据模型。
 *
 * @param type 类型标识。
 * @param key 密钥。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiAuth(@JsonProperty("type") String type, @JsonProperty("key") String key)
    implements Auth {}
