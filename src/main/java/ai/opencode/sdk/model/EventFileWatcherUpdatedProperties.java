package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件监听器已更新事件属性。
 *
 * @param file 文件信息。
 * @param event 事件名称。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventFileWatcherUpdatedProperties(
    @JsonProperty("file") String file, @JsonProperty("event") String event) {}
