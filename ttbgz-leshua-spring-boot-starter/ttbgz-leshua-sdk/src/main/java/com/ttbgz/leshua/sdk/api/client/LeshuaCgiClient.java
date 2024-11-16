package com.ttbgz.leshua.sdk.api.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ttbgz.leshua.sdk.api.config.LeshuaConfig;
import com.ttbgz.leshua.sdk.api.request.LeshuaCgiRequest;
import com.ttbgz.leshua.sdk.api.response.LeshuaCgiResponse;
import com.ttbgz.leshua.sdk.remote.CgiInput;
import com.ttbgz.leshua.sdk.util.FieldValueUtil;
import com.ttbgz.leshua.sdk.util.SignUtils;
import com.ttbgz.leshua.sdk.util.XmlUtils;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;

/**
 * @author Claire
 * @date 2022/8/27 16:41
 * @description
 */
public class LeshuaCgiClient<T> extends LeshuaBasicClient<T, LeshuaCgiResponse<T>, LeshuaCgiRequest<T>> {
    public LeshuaCgiClient(LeshuaConfig leshuaConfig) {
        super(leshuaConfig);
    }
    @Override
    public LeshuaCgiResponse<T> execute(LeshuaCgiRequest<T> request) {
        return super.execute(request);
    }

    @Override
    public LeshuaCgiResponse<T> execute(LeshuaConfig leshuaConfig, LeshuaCgiRequest<T> request) {
        return super.execute(leshuaConfig, request);
    }

    @Override
    protected LeshuaCgiResponse<T> parseResponseFromEx(ApiException e) {
        return new LeshuaCgiResponse("-1","网络异常[" + e.getCode() + "]，请检查网络和配置参数，或联系运营人员");
    }

    @Override
    protected ApiInput getApiInput(LeshuaConfig leshuaConfig, LeshuaCgiRequest<T> request) {
        String key = leshuaConfig.getKey();
        String charset = leshuaConfig.getCharset();
        // 全部的参数
        JSONObject data = request.getData();
        String apiMethodName = request.getApiMethodName();
        CgiInput input = new CgiInput();
        String sign = SignUtils.getSign(key, charset, data);
        input.addParameter("sign", sign);
        for (String key1 : data.keySet()) {
            Object value = data.get(key1);
            if (value != null) {
                FieldValueUtil.setValue(input, key1, value);
            }
        }
        input.setMethod(ApiInvokeMethod.fromString(request.getMethod()));
        input.setUrl(leshuaConfig.getServerUrl() + apiMethodName);
        input.setTimeOut(leshuaConfig.getReadTimeout());
        return input;
    }

    @Override
    protected LeshuaCgiResponse<T> parseResponse(String responseStr) {
        return XmlUtils.xmlStr2Object(responseStr, new TypeReference<LeshuaCgiResponse<T>>(){});
    }

}
