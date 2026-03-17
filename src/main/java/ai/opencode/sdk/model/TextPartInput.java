package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 文本片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param text 文本内容。
 * @param synthetic synthetic标记。
 * @param ignored ignored标记。
 * @param time 时间。
 * @param metadata metadata映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TextPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("text") String text,
    @JsonProperty("synthetic") Boolean synthetic,
    @JsonProperty("ignored") Boolean ignored,
    @JsonProperty("time") TextPartInputTime time,
    @JsonProperty("metadata") Map<String, JsonNode> metadata)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
