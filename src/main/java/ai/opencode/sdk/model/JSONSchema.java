package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;

/** JSON Schema 映射。 映射值类型为 JSON 节点。 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class JSONSchema extends LinkedHashMap<String, JsonNode> {
  /** 创建空映射对象。 */
  public JSONSchema() {
    super();
  }
}
