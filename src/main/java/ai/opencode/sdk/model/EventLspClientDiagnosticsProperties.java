package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 事件LSP客户端诊断属性。
 *
 * @param serverID 服务端 ID。
 * @param path 目标文件或目录路径。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventLspClientDiagnosticsProperties(
    @JsonProperty("serverID") String serverID, @JsonProperty("path") String path) {}
