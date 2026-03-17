package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 代理片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param name 名称。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("name") String name,
    @JsonProperty("source") AgentPartInputSource source)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
