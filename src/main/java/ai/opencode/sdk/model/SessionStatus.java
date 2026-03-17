package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** 会话状态联合类型。 实际实现类型由 type 字段判别。 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SessionStatusIdle.class, name = "idle"),
  @JsonSubTypes.Type(value = SessionStatusRetry.class, name = "retry"),
  @JsonSubTypes.Type(value = SessionStatusBusy.class, name = "busy")
})
public sealed interface SessionStatus
    permits SessionStatusIdle, SessionStatusRetry, SessionStatusBusy {}
