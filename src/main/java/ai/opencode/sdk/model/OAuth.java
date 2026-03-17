package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OAuth数据模型。
 *
 * @param type 类型标识。
 * @param refresh 刷新令牌。
 * @param access 访问令牌。
 * @param expires 过期时间。
 * @param accountId 账户 ID。
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
