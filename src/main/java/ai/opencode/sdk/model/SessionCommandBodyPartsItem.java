package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** 会话命令请求体片段Item联合类型。 实际实现类型由 type 字段判别。 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = SessionCommandBodyPartsItemFile.class, name = "file")})
public sealed interface SessionCommandBodyPartsItem permits SessionCommandBodyPartsItemFile {}
