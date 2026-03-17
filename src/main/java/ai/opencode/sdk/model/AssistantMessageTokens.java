package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 助手消息令牌数据模型。
 *
 * @param total 总量。
 * @param input 输入。
 * @param output 输出。
 * @param reasoning 推理信息。
 * @param cache 缓存。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessageTokens(
    @JsonProperty("total") Double total,
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("reasoning") Double reasoning,
    @JsonProperty("cache") AssistantMessageTokensCache cache) {}
