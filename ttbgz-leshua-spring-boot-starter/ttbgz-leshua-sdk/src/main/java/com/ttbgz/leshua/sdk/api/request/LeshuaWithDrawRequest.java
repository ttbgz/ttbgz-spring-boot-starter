package com.ttbgz.leshua.sdk.api.request;


import com.ttbgz.leshua.sdk.api.response.LeshuaWithDrawResponse;

import java.util.Random;

/**
 * claire
 *
 * @param <T>
 */
public class LeshuaWithDrawRequest<T> extends LeshuaBasicRequest<T, LeshuaWithDrawResponse<T>> {
    private String reqSerialNo = String.valueOf(System.currentTimeMillis() + new Random().nextInt(10));



    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }


}
