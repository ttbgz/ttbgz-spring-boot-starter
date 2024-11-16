package com.ttbgz.aliyun.sms.service;

/**
 * @author ttbgz
 */
public interface AliyunSmsService {
    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * 不填写前面默认从，配置里面获取
     * @return 回执id
     */
    String sendSms(String phoneNumbers,String templateParam);

    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param signName  您可以通过 AddSmsSign 接口添加签名或在短信服务控制台添加签名，签名通过审核后，才可使用签名名称。
     * @param templateCode 短信模板Code。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * @return 回执id
     */
    String sendSms(String phoneNumbers,String signName,String templateCode,String templateParam);

}
