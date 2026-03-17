package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 应用日志请求体。
 *
 * @param service service。
 * @param level level。
 * @param message 消息内容。
 * @param extra extra映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppLogBody(
    @JsonProperty("service") String service,
    @JsonProperty("level") String level,
    @JsonProperty("message") String message,
    @JsonProperty("extra") Map<String, JsonNode> extra) {}
