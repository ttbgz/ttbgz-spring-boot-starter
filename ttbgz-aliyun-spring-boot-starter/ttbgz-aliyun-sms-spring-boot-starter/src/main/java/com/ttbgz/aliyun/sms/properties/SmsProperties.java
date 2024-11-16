package com.ttbgz.aliyun.sms.properties;

import com.ttbgz.aliyun.properties.AliyunProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.annotation.Resource;


/**
 * @author ttbgz
 * @date 2021/12/6
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "aliyun.sms",ignoreInvalidFields = true)
public class SmsProperties {

    @Resource private AliyunProperties aliyunProperties;

    /**
     * 短信模板code
     */
    private String templateCode;
    /**
     * 短信签名
     */
    private String signName;
    /**
     * 短信发送api
     */
    private String endpoint="dysmsapi.aliyuncs.com";


}
