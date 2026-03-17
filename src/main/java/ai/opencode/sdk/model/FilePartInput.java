package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param mime mime。
 * @param filename filename。
 * @param url 可访问的地址。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilePartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("mime") String mime,
    @JsonProperty("filename") String filename,
    @JsonProperty("url") String url,
    @JsonProperty("source") FilePartSource source)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
