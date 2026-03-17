package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 工具列表Item数据模型。
 *
 * @param id 唯一标识。
 * @param description 描述信息。
 * @param parameters parameters。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolListItem(
    @JsonProperty("id") String id,
    @JsonProperty("description") String description,
    @JsonProperty("parameters") JsonNode parameters) {}
