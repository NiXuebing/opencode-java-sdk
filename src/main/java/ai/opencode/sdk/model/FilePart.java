package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param mime MIME 类型。
 * @param filename 文件名。
 * @param url 可访问的地址。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilePart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("mime") String mime,
    @JsonProperty("filename") String filename,
    @JsonProperty("url") String url,
    @JsonProperty("source") FilePartSource source)
    implements Part {}
