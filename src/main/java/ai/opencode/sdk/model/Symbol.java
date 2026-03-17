package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 符号数据模型。
 *
 * @param name 名称。
 * @param kind 类型值。
 * @param location 位置信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Symbol(
    @JsonProperty("name") String name,
    @JsonProperty("kind") Double kind,
    @JsonProperty("location") SymbolLocation location) {}
