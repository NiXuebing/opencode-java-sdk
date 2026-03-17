package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件差异数据模型。
 *
 * @param file 文件信息。
 * @param before before。
 * @param after after。
 * @param additions additions。
 * @param deletions deletions。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileDiff(
    @JsonProperty("file") String file,
    @JsonProperty("before") String before,
    @JsonProperty("after") String after,
    @JsonProperty("additions") Double additions,
    @JsonProperty("deletions") Double deletions,
    @JsonProperty("status") String status) {}
