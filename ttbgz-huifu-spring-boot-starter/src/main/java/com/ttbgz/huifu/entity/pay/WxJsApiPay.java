package com.ttbgz.huifu.entity.pay;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @author ttbgz
 */
@Data
public class WxJsApiPay {

    private String appId;

    private String timeStamp;

    private String nonceStr;
    @JSONField(name = "package")
    private String packageValue;

    private String signType;

    private String paySign;
}
