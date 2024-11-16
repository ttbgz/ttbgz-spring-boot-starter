package com.ttbgz.leshua.sdk.api.client;


import com.ttbgz.leshua.sdk.api.config.LeshuaConfig;
import com.ttbgz.leshua.sdk.api.request.LeshuaRequest;
import com.ttbgz.leshua.sdk.api.response.LeshuaResponse;

/**
 * @author Claire
 * @date 2022/8/19 20:25
 * @description
 */
public interface LeshuaClient<T, T1 extends LeshuaResponse<T>, T2 extends LeshuaRequest<T, T1>> {
    T1 execute(T2 request);

    T1 execute(LeshuaConfig leshuaConfig, T2 request);
}
