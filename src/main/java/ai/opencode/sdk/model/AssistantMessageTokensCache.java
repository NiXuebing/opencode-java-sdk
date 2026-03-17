package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 助手消息令牌缓存数据模型。
 *
 * @param read read。
 * @param write write。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessageTokensCache(
    @JsonProperty("read") Double read, @JsonProperty("write") Double write) {}
