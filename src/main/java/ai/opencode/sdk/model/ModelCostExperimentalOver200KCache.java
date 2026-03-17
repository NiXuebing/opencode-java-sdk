package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模型成本实验性超长K缓存数据模型。
 *
 * @param read 读取信息。
 * @param write 写入信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCostExperimentalOver200KCache(
    @JsonProperty("read") Double read, @JsonProperty("write") Double write) {}
