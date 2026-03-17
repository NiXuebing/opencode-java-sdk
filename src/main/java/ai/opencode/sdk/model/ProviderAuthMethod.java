package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商认证方法数据模型。
 *
 * @param type 类型标识。
 * @param label 显示标签。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderAuthMethod(
    @JsonProperty("type") String type, @JsonProperty("label") String label) {}
