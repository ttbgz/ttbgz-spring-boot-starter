package com.ttbgz.huaweicloud.properties;

import com.ttbgz.huaweicloud.propperties.HuaweiCloudProperties;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author ttbgz
 * @date 2021/12/6
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "huawei.sms",ignoreInvalidFields = true)
public class HuaweiSmsProperties {

    @Resource private HuaweiCloudProperties huaweiCloudProperties;

    /**
     * 应用管理-应用ak
     */
    private String smsAppKey;
    /**
     * 应用管理-应用sk
     */
    private String smsAppSecret;
    /**
     * APP接入地址+接口访问URI
     */
    private String smsUrl="https://smsapi.cn-north-4.myhuaweicloud.com:443/sms/batchSendSms/v1";

    /**
     * 短信签名
     */
    private String smsSignature;

    /**
     * 短信发送方的号码。
     * 国内短信填写为短信平台为短信签名分配的通道号码，请在申请短信签名时获取签名通道号，如：csms100000001，且通道号码对应的签名类型和模板ID对应的模板类型必须相同。
     * 请在短信控制台“国内短信 > 签名管理”内查看签名的通道号，签名和模板为对应关系，模板所属签名可在“国内短信 > 模板管理”查看。
     */
    private String smsFrom;
    /**
     * 短信模板ID，用于唯一标识短信模板，请在申请短信模板时获取模板ID。
     * “templateId”需要与“templateParas”参数配合使用。
     */
    private String smsTemplateId;
    /**
     * 短信通道
     */
    private String smsSender;
    /**
     * 用户的回调地址，用于接收短信状态报告，如：https://my.com/receiveSMSReport。
     * 如果设置了该字段，则该消息的状态报告将通过“接收状态报告”接口直接通知用户。
     * 回调地址推荐使用域名。
     */
    private String statusCallback;
}
