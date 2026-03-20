package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 工具状态联合类型。
 * 实际实现类型由 status 字段判别。
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "status", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ToolStatePending.class, name = "pending"),
    @JsonSubTypes.Type(value = ToolStateRunning.class, name = "running"),
    @JsonSubTypes.Type(value = ToolStateCompleted.class, name = "completed"),
    @JsonSubTypes.Type(value = ToolStateError.class, name = "error")
})
public interface ToolState {
}
