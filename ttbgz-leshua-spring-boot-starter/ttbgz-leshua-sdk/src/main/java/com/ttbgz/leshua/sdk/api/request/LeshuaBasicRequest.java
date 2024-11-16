package com.ttbgz.leshua.sdk.api.request;

import com.alibaba.fastjson.JSONObject;
import com.ttbgz.leshua.sdk.api.response.LeshuaBasicResponse;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

public class LeshuaBasicRequest<T, T1 extends LeshuaBasicResponse<T>> implements LeshuaRequest<T, T1> {
    public LeshuaBasicRequest() {
    }

    private JSONObject data;
    private String apiMethodName;
    /**
     * 请求方法，默认为POST
     */
    private String method = ApiInvokeMethod.POST.toString();

    @Override
    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String getApiMethodName() {
        return apiMethodName;
    }

    public void setApiMethodName(String apiMethodName) {
        this.apiMethodName = apiMethodName;
    }

    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
