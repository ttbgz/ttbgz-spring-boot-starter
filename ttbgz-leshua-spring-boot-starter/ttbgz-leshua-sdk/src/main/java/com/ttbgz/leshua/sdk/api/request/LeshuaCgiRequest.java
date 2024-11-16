package com.ttbgz.leshua.sdk.api.request;


import com.ttbgz.leshua.sdk.api.response.LeshuaCgiResponse;

import java.util.Random;

/**
 * claire
 *
 * @param <T>
 */
public class LeshuaCgiRequest<T> extends LeshuaBasicRequest<T, LeshuaCgiResponse<T>> {
    private String reqSerialNo = String.valueOf(System.currentTimeMillis() + new Random().nextInt(10));




    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }


}
