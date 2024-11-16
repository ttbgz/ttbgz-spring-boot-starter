package com.ttbgz.leshua.sdk.api.client;

import com.ttbgz.leshua.sdk.api.config.LeshuaConfig;
import com.ttbgz.leshua.sdk.api.request.LeshuaBasicRequest;
import com.ttbgz.leshua.sdk.api.response.LeshuaBasicResponse;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInvokeSupport;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;

/**
 * @author Claire 抽象的客户端
 * @date 2022/8/27 12:09
 * @description
 */
public abstract class LeshuaBasicClient<T, T1 extends LeshuaBasicResponse<T>, T2 extends LeshuaBasicRequest<T, T1>> implements LeshuaClient<T, T1, T2> {
    private LeshuaConfig leshuaConfig;

    public LeshuaBasicClient(LeshuaConfig leshuaConfig) {
        this.leshuaConfig = leshuaConfig;
    }


    @Override
    public T1 execute(T2 request) {
        return execute(leshuaConfig, request);
    }

    @Override
    public T1 execute(LeshuaConfig leshuaConfig, T2 request) {
        ApiInput input = getApiInput(leshuaConfig, request);
        try {
            String responseStr = ApiInvokeSupport.getStringResponse(input);
            T1 response = parseResponse(responseStr);
            return response;
        } catch (ApiException e) {
            return parseResponseFromEx(e);
        }
    }



    /**
     * 从异常中解析返回数据
     *
     * @param e
     * @return
     */
    protected abstract T1 parseResponseFromEx(ApiException e);


    /**
     * 获取apiInput 方法需要具体实现
     *
     * @param leshuaConfig
     * @param request
     * @return
     */
    protected abstract ApiInput getApiInput(LeshuaConfig leshuaConfig, T2 request);

    /**
     * 从返回体中解析成预期的JAVA对象需要具体类实现
     *
     * @param responseStr
     * @param responseClass
     * @return
     */
    protected abstract T1 parseResponse(String responseStr);


    public LeshuaConfig getLeshuaConfig() {
        return leshuaConfig;
    }

    public void setLeshuaConfig(LeshuaConfig leshuaConfig) {
        this.leshuaConfig = leshuaConfig;
    }
}
