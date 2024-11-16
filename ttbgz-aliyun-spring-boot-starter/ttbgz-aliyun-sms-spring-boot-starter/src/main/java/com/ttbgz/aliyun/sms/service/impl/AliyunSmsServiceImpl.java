package com.ttbgz.aliyun.sms.service.impl;

import com.alibaba.fastjson2.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import com.ttbgz.aliyun.sms.properties.SmsProperties;
import com.ttbgz.aliyun.sms.service.AliyunSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @author ttbgz
 */
@Slf4j
@Service
public class AliyunSmsServiceImpl implements AliyunSmsService {

    @Resource
    private SmsProperties smsProperties;

    @Resource(name = "aliyunSmsConfig")
    private Config aliyunSmsConfig;

    /**
     * 发送短信方法
     * @param phoneNumbers 支持对多个手机号码发送短信，手机号码之间以半角逗号（,）分隔。上限为 1000 个手机号码。
     * @param signName  您可以通过 AddSmsSign 接口添加签名或在短信服务控制台添加签名，签名通过审核后，才可使用签名名称。
     * @param templateCode 短信模板Code。
     * @param templateParam 短信模板变量对应的实际值 {"name":"张三","code":"05586"}
     * @return 回执id
     * @throws Exception
     */
    private String sendSmsExecute(String phoneNumbers,String signName,String templateCode,String templateParam) {
        Client client = null;
        try {
            client = new Client(aliyunSmsConfig);
        } catch (Exception e) {
            log.error("连接阿里云短信异常:{0}",e);
            throw new RuntimeException(e);
        }

        SendSmsRequest sendSmsRequest = new SendSmsRequest();

        sendSmsRequest.setPhoneNumbers(phoneNumbers);
        //短息模板
        if (templateCode==null){
            sendSmsRequest.setTemplateCode(smsProperties.getTemplateCode());
        }else{
            sendSmsRequest.setTemplateCode(templateCode);
        }
        //短信签名
        if (signName!=null){
            sendSmsRequest.setSignName(signName);
        }else{
            sendSmsRequest.setSignName(smsProperties.getSignName());
        }

        //发送参数
        if (templateParam!=null){
            sendSmsRequest.setTemplateParam(templateParam);
        }

        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse sendSmsResponse=client.sendSmsWithOptions(sendSmsRequest, runtime);
            SendSmsResponseBody sendSmsResponseBody=sendSmsResponse.getBody();
            if ("OK".equals(sendSmsResponseBody.getCode())){
                return sendSmsResponseBody.getBizId();
            }else{
                log.error("短信发送失败:{}", JSON.toJSON(sendSmsResponseBody));
                throw new RuntimeException("发送短信失败:"+sendSmsResponseBody.getMessage());
            }

        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            log.error(error.getMessage());
            // 诊断地址
            log.error("error: {}",error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            log.error(error.getMessage());
            // 诊断地址
            log.error("sms exception error {}:",error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return null;
    }

    @Override
    public String sendSms(String phoneNumbers, String templateParam) {
        return this.sendSmsExecute(phoneNumbers, null, null, templateParam);
    }

    @Override
    public String sendSms(String phoneNumbers, String signName, String templateCode, String templateParam) {
        String bizId;
        try {
            bizId = this.sendSmsExecute(phoneNumbers, signName, templateCode, templateParam);
        } catch (Exception e) {
            throw new RuntimeException("发送短信失败!");
        }
        return bizId;
    }
}
