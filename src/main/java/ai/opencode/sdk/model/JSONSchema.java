package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;

/** JSON结构映射结果。 映射值类型为 JSONNode。 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class JSONSchema extends LinkedHashMap<String, JsonNode> {
  /** 创建空映射对象。 */
  public JSONSchema() {
    super();
  }
}
