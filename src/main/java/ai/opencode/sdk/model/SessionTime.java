package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话时间数据模型。
 *
 * @param created 已创建。
 * @param updated 已更新。
 * @param compacting compacting。
 * @param archived archived。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionTime(
    @JsonProperty("created") Double created,
    @JsonProperty("updated") Double updated,
    @JsonProperty("compacting") Double compacting,
    @JsonProperty("archived") Double archived) {}
