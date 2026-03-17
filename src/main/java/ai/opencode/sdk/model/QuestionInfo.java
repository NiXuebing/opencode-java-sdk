package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 问题信息数据模型。
 *
 * @param question 问题。
 * @param header 标题。
 * @param options 选项列表。
 * @param multiple 是否允许多选。
 * @param custom 是否允许自定义输入。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionInfo(
    @JsonProperty("question") String question,
    @JsonProperty("header") String header,
    @JsonProperty("options") List<QuestionOption> options,
    @JsonProperty("multiple") Boolean multiple,
    @JsonProperty("custom") Boolean custom) {}
