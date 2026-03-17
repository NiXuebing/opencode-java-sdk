package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** 认证联合类型。 实际实现类型由 type 字段判别。 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = OAuth.class, name = "oauth"),
  @JsonSubTypes.Type(value = ApiAuth.class, name = "api"),
  @JsonSubTypes.Type(value = WellKnownAuth.class, name = "wellknown")
})
public sealed interface Auth permits OAuth, ApiAuth, WellKnownAuth {}
