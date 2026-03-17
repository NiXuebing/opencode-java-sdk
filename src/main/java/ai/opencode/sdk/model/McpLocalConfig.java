package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * MCP本地配置。
 *
 * @param type 类型标识。
 * @param command 命令内容。
 * @param environment 环境变量映射。
 * @param enabled 是否启用。
 * @param timeout 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpLocalConfig(
    @JsonProperty("type") String type,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("timeout") Long timeout)
    implements McpAddBodyConfig {}
