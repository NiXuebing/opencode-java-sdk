package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 项目Icon数据模型。
 *
 * @param url 可访问的地址。
 * @param override override。
 * @param color color。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProjectIcon(
    @JsonProperty("url") String url,
    @JsonProperty("override") String override,
    @JsonProperty("color") String color) {}
