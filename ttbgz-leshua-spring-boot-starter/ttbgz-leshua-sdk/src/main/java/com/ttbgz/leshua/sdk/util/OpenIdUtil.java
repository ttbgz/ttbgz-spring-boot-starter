package com.ttbgz.leshua.sdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInvokeSupport;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Description  获取交易时所需的openid
 **/

public class OpenIdUtil {

    private static Logger logger = LoggerFactory.getLogger(OpenIdUtil.class);
    // 微信 openid 地址
    public static String WXURL="https://api.weixin.qq.com/sns/oauth2/access_token";
    // 支付宝 userId 地址
    public static String ZFBURL = "https://openapi.alipay.com/gateway.do";

    @API(method = ApiInvokeMethod.GET,contentType = ApiConstants.APPLICATION_FORM_URLENCODED_VALUE)
    static class SimpleInput extends ApiInput {
    }
    /**
     * @Description //微信公众号获取openid
     * 参考文档：https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html

     **/

    public static String getWXJsapiOpenId(String appId,String code,String appsecret){
        ApiInput apiInput = new SimpleInput();
        apiInput.setUrl(WXURL);
        apiInput.setMethod(ApiInvokeMethod.GET);
        apiInput.addParameter("appId",appId);
        apiInput.addParameter("secret",appsecret);
        apiInput.addParameter("grant_type","authorization_code");
        apiInput.addParameter("code",code);
        String response = ApiInvokeSupport.getStringResponse(apiInput);
        JSONObject jsonObject = JSON.parseObject(response);
        return jsonObject.getString("openId");
    }

    public static String getZFBJsapiUserId(String appId,String code){
        SimpleInput simpleInput = new SimpleInput();
        simpleInput.setUrl(ZFBURL);
        simpleInput.setMethod(ApiInvokeMethod.POST);
        //配置参数
        simpleInput.addParameter("app_id",appId);
        simpleInput.addParameter("method","alipay.system.oauth.token");
        simpleInput.addParameter("charset","GBK");
        simpleInput.addParameter("sign_type","RSA2");
        simpleInput.addParameter("timestamp",System.currentTimeMillis()+"");
        simpleInput.addParameter("version","1.0");
        simpleInput.addParameter("grant_type","authorization_code");
        simpleInput.addParameter("code",code);
        // map 加密
        Map<String, String> map = simpleInput.getParameters();
        String sign = SignUtils.sha256SignMap(map);
        simpleInput.addParameter("sign",sign);
        // 发送请求
        String response = ApiInvokeSupport.getStringResponse(simpleInput);
        JSONObject jsonObject = JSON.parseObject(response);
        return jsonObject.getString("user_id");
    }




    public static void main(String[] args) {
        String openId = getWXJsapiOpenId("xxx", "bbbb", "ccccc");
        //String userId=getZFBJsapiUserId("2014070100171525","4b203fe6c11548bcabd8da5bb087a83b");
        //logger.info("result: {}",userId);
    }
}
