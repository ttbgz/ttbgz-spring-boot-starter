package com.ttbgz.leshua.sdk.api.response;

/**
 * @author Claire
 * @date 2022/8/27 11:36
 * @description
 */
public interface LeshuaResponse<T> {
    T getData();

    boolean isSuccess();
}
