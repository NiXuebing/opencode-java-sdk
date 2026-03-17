package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Pty数据模型。
 *
 * @param id 唯一标识。
 * @param title 标题。
 * @param command 命令内容。
 * @param args 参数列表。
 * @param cwd cwd。
 * @param status 当前状态。
 * @param pid pid。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Pty(
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("command") String command,
    @JsonProperty("args") List<String> args,
    @JsonProperty("cwd") String cwd,
    @JsonProperty("status") String status,
    @JsonProperty("pid") Double pid) {}
