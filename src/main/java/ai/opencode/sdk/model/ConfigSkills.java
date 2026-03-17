package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 配置技能数据模型。
 *
 * @param paths 路径列表。
 * @param urls 地址列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigSkills(
    @JsonProperty("paths") List<String> paths, @JsonProperty("urls") List<String> urls) {}
