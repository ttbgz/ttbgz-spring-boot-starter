package com.ttbgz.leshua.sdk.api.request;


import com.ttbgz.leshua.sdk.api.response.LeshuaRegisterResponse;

import java.util.Random;

/**
 * claire
 *
 * @param <T>
 */
public class LeshuaRegisterJsonRequest<T> extends LeshuaBasicRequest<T, LeshuaRegisterResponse<T>> {
    public LeshuaRegisterJsonRequest() {

    }


    private String reqSerialNo = String.valueOf(System.currentTimeMillis() + new Random().nextInt(10));

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }
}
