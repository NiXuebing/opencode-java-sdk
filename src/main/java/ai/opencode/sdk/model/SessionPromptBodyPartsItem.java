package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** 会话提示词请求体片段项联合类型。 实际实现类型由 type 字段判别。 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TextPartInput.class, name = "text"),
  @JsonSubTypes.Type(value = FilePartInput.class, name = "file"),
  @JsonSubTypes.Type(value = AgentPartInput.class, name = "agent"),
  @JsonSubTypes.Type(value = SubtaskPartInput.class, name = "subtask")
})
public sealed interface SessionPromptBodyPartsItem
    permits TextPartInput, FilePartInput, AgentPartInput, SubtaskPartInput {}
