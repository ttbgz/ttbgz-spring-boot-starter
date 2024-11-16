package com.ttbgz.leshua.sdk.api.response;

/**
 * @author Claire
 * @date 2022/8/27 11:51
 * @description
 */
public class LeshuaBasicResponse<T> implements LeshuaResponse<T> {
    public LeshuaBasicResponse(T data) {
        this.data = data;
    }

    public LeshuaBasicResponse() {

    }

    private T data;

    @Override
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
