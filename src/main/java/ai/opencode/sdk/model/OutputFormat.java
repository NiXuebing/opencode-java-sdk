package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 输出格式联合类型。
 * 实际实现类型由 type 字段判别。
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OutputFormatText.class, name = "text"),
    @JsonSubTypes.Type(value = OutputFormatJsonSchema.class, name = "json_schema")
})
public interface OutputFormat {
}
