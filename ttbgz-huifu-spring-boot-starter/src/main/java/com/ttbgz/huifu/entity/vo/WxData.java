package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信支付参数
 * @author ttbgz
 */
@Data
public class WxData implements Serializable {

    /**
     * 微信openId
     */
    @JSONField(name = "sub_openid")
    private String subOpenid;
}
