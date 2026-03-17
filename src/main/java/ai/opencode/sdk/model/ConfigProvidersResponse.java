package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 配置提供商响应数据。
 *
 * @param providers 提供商列表。
 * @param defaultValue 默认映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigProvidersResponse(
    @JsonProperty("providers") List<Provider> providers,
    @JsonProperty("default") Map<String, String> defaultValue) {}
