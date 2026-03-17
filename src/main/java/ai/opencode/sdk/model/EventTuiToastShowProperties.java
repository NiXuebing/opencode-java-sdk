package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TUI提示显示事件属性。
 *
 * @param title 标题。
 * @param message 消息内容。
 * @param variant 变体名称。
 * @param duration 持续时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTuiToastShowProperties(
    @JsonProperty("title") String title,
    @JsonProperty("message") String message,
    @JsonProperty("variant") String variant,
    @JsonProperty("duration") Double duration) {}
