package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 文本片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param text 文本内容。
 * @param synthetic 合成标记。
 * @param ignored 是否忽略。
 * @param time 时间。
 * @param metadata 元数据映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TextPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("text") String text,
    @JsonProperty("synthetic") Boolean synthetic,
    @JsonProperty("ignored") Boolean ignored,
    @JsonProperty("time") TextPartTime time,
    @JsonProperty("metadata") Map<String, JsonNode> metadata)
    implements Part {}
