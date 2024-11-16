package com.ttbgz.huaweicloud.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.cloud.apigateway.sdk.utils.Client;
import com.cloud.apigateway.sdk.utils.Request;

import com.ttbgz.huaweicloud.pojo.HuaweiSmsResult;
import com.ttbgz.huaweicloud.properties.HuaweiSmsProperties;
import com.ttbgz.huaweicloud.service.HuaweiSmsService;
import com.ttbgz.huaweicloud.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.http.HttpResponse;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;


/**
 * @author suetian
 */
@Service
@Slf4j
public class HuaweiSmsServiceImpl implements HuaweiSmsService {
    public static final String UTF_8 = "UTF-8";

    @Autowired private HuaweiSmsProperties huaweiSmsProperties;

    @Override
    public HuaweiSmsResult sendSms(String phoneNumbers, String templateParam) {
        String[] arr=new String[]{templateParam};
        return sendSmsExecute(phoneNumbers, arr,huaweiSmsProperties.getSmsSender(),huaweiSmsProperties.getSmsTemplateId(),null,huaweiSmsProperties.getSmsSignature());
    }
    @Override
    public HuaweiSmsResult sendSms(String phoneNumbers, String templateParam,String smsSender,String smsTemplateId) {
        String[] arr=new String[]{templateParam};
        return sendSmsExecute(phoneNumbers, arr,smsSender,smsTemplateId,null,huaweiSmsProperties.getSmsSignature());
    }

    @Override
    public HuaweiSmsResult sendSms(String phoneNumbers, String[] templateParam) {
        return sendSmsExecute(phoneNumbers, templateParam,huaweiSmsProperties.getSmsSender(),huaweiSmsProperties.getSmsTemplateId(),null,huaweiSmsProperties.getSmsSignature());
    }
    @Override
    public HuaweiSmsResult sendSms(String phoneNumbers, String[] templateParam,String smsSender,String smsTemplateId) {
        return sendSmsExecute(phoneNumbers, templateParam,smsSender,smsTemplateId,null,huaweiSmsProperties.getSmsSignature());
    }

    /**
     * 发送短信执行方法
     * @param phoneNumbers 接受短信方
     * @param phoneNumbersParam 短信模板参数
     * @param sender 短信发送方
     * @param templateId 短信模板ID
     * @param statusCallBack 回调地址
     * @param signature 签名
     * @return
     */

    public HuaweiSmsResult sendSmsExecute(String phoneNumbers, String[] phoneNumbersParam,String sender,String templateId,
                                 String statusCallBack, String signature)  {
        CloseableHttpClient closeableHttpClient = createIgnoreSslHttpClient();

        //请求Body,不携带签名名称时,signature请填null
        String templateParas=JSONArray.toJSONString(phoneNumbersParam);
        String body = buildRequestBody(sender, phoneNumbers, templateId, templateParas, statusCallBack, "ceshi");
        if (null == body || body.isEmpty()) {
            log.warn("body is null.");
            return new HuaweiSmsResult(500,"body is null","");
        }
        // Create a new request.
        Request request = new Request();
        try {
            request.setKey(huaweiSmsProperties.getSmsAppKey());
            request.setSecret(huaweiSmsProperties.getSmsAppSecret());
            request.setMethod("POST");
            request.addHeader("Content-Type", "application/x-www-form-urlencoded");
            request.setUrl(huaweiSmsProperties.getSmsUrl());
            request.setBody(body);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            HttpRequestBase signedRequest = Client.sign(request, Constant.SIGNATURE_ALGORITHM_SDK_HMAC_SHA256);
            log.info("Print the authorization: {}", Arrays.toString(signedRequest.getHeaders("Authorization")));
            Header[] requestAllHeaders = signedRequest.getAllHeaders();
            for (Header h : requestAllHeaders) {
                log.info("req Header with name: {} and value: {}", h.getName(), h.getValue());
            }

            HttpResponse response = closeableHttpClient.execute(signedRequest);

            log.info("Print the status line of the response: {}", response.getStatusLine().toString());
            Header[] resHeaders = response.getAllHeaders();
            for (Header h : resHeaders) {
                log.info("Processing Header with name: {} and value: {}", h.getName(), h.getValue());
            }
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                String result=EntityUtils.toString(resEntity, "UTF-8");
                log.info("短信发送完毕{}",result);
                return JSON.parseObject(result, HuaweiSmsResult.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("发送短信失败");
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new HuaweiSmsResult(500,"发送短信失败","");
    }

    static String buildRequestBody(String sender, String receiver, String templateId, String templateParas,
                                   String statusCallBack, String signature){
        if (null == sender || null == receiver || null == templateId || sender.isEmpty() || receiver.isEmpty()
                || templateId.isEmpty()) {
            System.out.println("buildRequestBody(): sender, receiver or templateId is null.");
            return null;
        }
        StringBuilder body = new StringBuilder();
        try {
            appendToBody(body, "from=", sender);
            appendToBody(body, "&to=", receiver);
            appendToBody(body, "&templateId=", templateId);
            appendToBody(body, "&templateParas=", templateParas);
            appendToBody(body, "&statusCallback=", statusCallBack);
            appendToBody(body, "&signature=", signature);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return body.toString();
    }
    private static void appendToBody(StringBuilder body, String key, String val) throws UnsupportedEncodingException {
        if (null != val && !val.isEmpty()) {
            log.info("Print appendToBody: {}:{}", key, val);
            body.append(key).append(URLEncoder.encode(val, UTF_8));
        }
    }
    public static CloseableHttpClient createIgnoreSslHttpClient() {
        SSLContext sslContext =null;
        try{
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (x509CertChain, authType) -> true).build();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)).build();
    }
}
