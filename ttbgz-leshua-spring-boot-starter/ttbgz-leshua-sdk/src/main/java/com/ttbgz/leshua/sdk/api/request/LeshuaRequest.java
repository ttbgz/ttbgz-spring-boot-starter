package com.ttbgz.leshua.sdk.api.request;

import com.alibaba.fastjson.JSONObject;
import com.ttbgz.leshua.sdk.api.response.LeshuaResponse;

/**
 * @author Claire
 * @date 2022/8/19 20:38
 * @description
 */
public interface LeshuaRequest<T, T1 extends LeshuaResponse<T>> {

    String getApiMethodName();

    String getMethod();

    public JSONObject getData();
}
