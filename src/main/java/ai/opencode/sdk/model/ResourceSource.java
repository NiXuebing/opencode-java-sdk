package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resource来源数据模型。
 *
 * @param text 文本内容。
 * @param type 类型标识。
 * @param clientName 客户端名称。
 * @param uri URI 地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResourceSource(
    @JsonProperty("text") FilePartSourceText text,
    @JsonProperty("type") String type,
    @JsonProperty("clientName") String clientName,
    @JsonProperty("uri") String uri)
    implements FilePartSource {}
