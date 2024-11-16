package com.ttbgz.aliyun.dypls.service.impl;

import com.alibaba.fastjson2.JSON;
import com.aliyun.dyplsapi20170525.Client;
import com.aliyun.dyplsapi20170525.models.BindAxbRequest;
import com.aliyun.dyplsapi20170525.models.BindAxbResponseBody;
import com.aliyun.dyplsapi20170525.models.UnbindSubscriptionResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.ttbgz.aliyun.dypls.properties.DyplsProperties;
import com.ttbgz.aliyun.dypls.service.DyplService;
import com.ttbgz.aliyun.dypls.CallRestrictEnum;
import com.ttbgz.aliyun.dypls.pojo.SecretBindDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 */
@Slf4j
@Service
public class DyplServiceImpl implements DyplService {

    @Resource(name = "dyplConfig")
    Config config;
    @Resource
    DyplsProperties dyplsProperties;

    @Override
    public SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, LocalDateTime expiration) {
        return this.createBindAxbRequestExecute(phoneNoA,phoneNoB,null,expiration,null,true,null);
    }

    @Override
    public SecretBindDTO createBindAxbRequestCloseArs(String phoneNoA, String phoneNoB, LocalDateTime expiration) {
        return this.createBindAxbRequestExecute(phoneNoA,phoneNoB,null,expiration,null,false,null);
    }

    @Override
    public SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, LocalDateTime expiration, boolean enableArs, String outId) {
        return this.createBindAxbRequestExecute(phoneNoA,phoneNoB,null,expiration,null,false,outId);
    }

    @Override
    public SecretBindDTO createBindAxbRequestEnableArs(String phoneNoA, String phoneNoB, LocalDateTime expiration, boolean enableArs) {
        return this.createBindAxbRequestExecute(phoneNoA,phoneNoB,null,expiration,null,enableArs,null);
    }

    @Override
    public SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, String phoneNoX, LocalDateTime expiration, CallRestrictEnum callRestrictEnum,boolean enableArs){
        return this.createBindAxbRequestExecute(phoneNoA, phoneNoB, phoneNoX, expiration, CallRestrictEnum.CONTROL_AX_DISABLE,enableArs,null);
    }

    @Override
    public SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, String phoneNoX, LocalDateTime expiration, CallRestrictEnum callRestrictEnum, boolean enableArs, String outId) {
        return this.createBindAxbRequestExecute(phoneNoA, phoneNoB, phoneNoX, expiration, CallRestrictEnum.CONTROL_AX_DISABLE,enableArs,outId);
    }

    @Override
    public UnbindSubscriptionResponse unbindSubscription(String poolKey, String secretNo, String subsId) {
        try {
            Client client =  new Client(config);
            com.aliyun.dyplsapi20170525.models.UnbindSubscriptionRequest unbindSubscriptionRequest = new com.aliyun.dyplsapi20170525.models.UnbindSubscriptionRequest();
            unbindSubscriptionRequest.setSecretNo(secretNo);
            unbindSubscriptionRequest.setSubsId(subsId);
            unbindSubscriptionRequest.setPoolKey(poolKey);
            com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
            // 复制代码运行请自行打印 API 的返回值
            UnbindSubscriptionResponse unbindSubscriptionResponse=client.unbindSubscriptionWithOptions(unbindSubscriptionRequest, runtime);
            return unbindSubscriptionResponse;
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            log.error(error.getMessage());
            com.aliyun.teautil.Common.assertAsString(error.message);
            throw new RuntimeException("取消绑定虚拟号异常");
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            log.error(error.getMessage());
            com.aliyun.teautil.Common.assertAsString(error.message);
            throw new RuntimeException("取消绑定虚拟号异常");
        }
    }

    public SecretBindDTO createBindAxbRequestExecute(String phoneNoA, String phoneNoB, String phoneNoX, LocalDateTime expiration, CallRestrictEnum callRestrictEnum,boolean isRecordingEnabled,String outId) {
        BindAxbResponseBody bindAxbResponseBody=new BindAxbResponseBody();
        try {
        Client client =  new Client(config);
        BindAxbRequest bindAxbRequest = new BindAxbRequest();
            bindAxbRequest.setPhoneNoA(phoneNoA);
            bindAxbRequest.setPhoneNoB(phoneNoB);
            bindAxbRequest.setPoolKey(dyplsProperties.getPoolKey());
            bindAxbRequest.setExpiration(expiration.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        if (phoneNoX!=null){
            bindAxbRequest.setPhoneNoX(phoneNoX);
        }
        if (callRestrictEnum!=null){
            bindAxbRequest.setCallRestrict(callRestrictEnum.name().toUpperCase());
        }
        //判断是否开启 录音
        if (isRecordingEnabled){
            bindAxbRequest.setIsRecordingEnabled(true);
        }
        //判断是否有外部ID
        if(outId!=null && !outId.isBlank()){
            bindAxbRequest.setOutId(outId);
        }

        RuntimeOptions runtime = new RuntimeOptions();
            // 复制代码运行请自行打印 API 的返回值
            bindAxbResponseBody=client.bindAxbWithOptions(bindAxbRequest, runtime).getBody();
            if ("OK".equals(bindAxbResponseBody.getCode())){
                BindAxbResponseBody.BindAxbResponseBodySecretBindDTO bind=bindAxbResponseBody.getSecretBindDTO();
                return new SecretBindDTO(bind.getExtension(),bind.getSecretNo(),bind.getSubsId());
            }else{
                log.error("入参:{}",JSON.toJSONString(bindAxbRequest));
                log.error("绑定失败:{}", JSON.toJSON(bindAxbResponseBody));
                throw new RuntimeException("绑定失败"+bindAxbResponseBody.getCode()+" "+bindAxbResponseBody.getMessage());
            }
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            log.error("绑定异常 Recommend {} 异常信息: {1}",JSON.toJSONString(bindAxbResponseBody),error);
            // 诊断地址
            Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 诊断地址
            log.error("绑定异常 Recommend {} 异常信息: {1}",JSON.toJSONString(bindAxbResponseBody),error);
            Common.assertAsString(error.message);
        }
        return new SecretBindDTO();
    }
}
