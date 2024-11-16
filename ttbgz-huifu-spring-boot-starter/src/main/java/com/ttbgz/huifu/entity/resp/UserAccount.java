package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAccount extends HuiFuResp {
    /**
     * 汇付ID
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     *管理员账号
     */
    @JSONField(name = "login_name")
    private String loginName;
    /**
     * 管理员密码
     */
    @JSONField(name = "login_password")
    private String loginPassword;

}
