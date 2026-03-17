package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * O认证数据模型。
 *
 * @param type 类型标识。
 * @param refresh refresh。
 * @param access access。
 * @param expires expires。
 * @param accountId accountId。
 * @param enterpriseUrl 企业版地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record OAuth(
    @JsonProperty("type") String type,
    @JsonProperty("refresh") String refresh,
    @JsonProperty("access") String access,
    @JsonProperty("expires") Double expires,
    @JsonProperty("accountId") String accountId,
    @JsonProperty("enterpriseUrl") String enterpriseUrl)
    implements Auth {}
