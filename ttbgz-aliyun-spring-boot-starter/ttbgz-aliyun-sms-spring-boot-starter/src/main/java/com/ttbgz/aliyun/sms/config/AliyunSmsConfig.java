package com.ttbgz.aliyun.sms.config;

import com.aliyun.teaopenapi.models.Config;
import com.ttbgz.aliyun.sms.properties.SmsProperties;
import com.ttbgz.aliyun.sms.service.impl.AliyunSmsServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.Resource;

@EnableConfigurationProperties(value = {SmsProperties.class})
public class AliyunSmsConfig {

    @Resource
    SmsProperties smsProperties;

    @Bean(name = "aliyunSmsConfig")
    public Config aliyunSmsConfig() throws Exception {
        return new Config()
                .setAccessKeyId(smsProperties.getAliyunProperties().getAccessKeyId())
                .setAccessKeySecret(smsProperties.getAliyunProperties().getAccessKeySecret())
                .setEndpoint(smsProperties.getEndpoint());
    }

    @Bean
    public AliyunSmsServiceImpl aliyunSmsService(){
        return new AliyunSmsServiceImpl();
    }
}
