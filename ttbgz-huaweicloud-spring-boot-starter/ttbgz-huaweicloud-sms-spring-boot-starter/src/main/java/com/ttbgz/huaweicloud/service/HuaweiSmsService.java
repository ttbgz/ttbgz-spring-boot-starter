package com.ttbgz.huaweicloud.service;

import com.ttbgz.huaweicloud.pojo.HuaweiSmsResult;

/**
 * @author ttbgz
 */
public interface HuaweiSmsService {
    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * 不填写前面默认从，配置里面获取
     * @return 回执id
     */
    HuaweiSmsResult sendSms(String phoneNumbers, String templateParam);
    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * @param smsSender 通道id
     * @param smsTemplateId 短信模板id
     * 不填写前面默认从，配置里面获取
     * @return 回执id
     */
    HuaweiSmsResult sendSms(String phoneNumbers, String templateParam,String smsSender,String smsTemplateId);
    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * 不填写前面默认从，配置里面获取
     * @return 回执id
     */
    HuaweiSmsResult sendSms(String phoneNumbers,String[] templateParam);
    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * @param smsSender 通道id
     * @param smsTemplateId 短信模板id
     * 不填写前面默认从，配置里面获取
     * @return 回执id
     */
    HuaweiSmsResult sendSms(String phoneNumbers,String[] templateParam,String smsSender,String smsTemplateId);
}
