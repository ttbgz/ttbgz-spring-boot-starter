package com.ttbgz.leshua.sdk.api.request;


import com.ttbgz.leshua.sdk.api.response.LeshuaRegisterResponse;

import java.io.File;
import java.util.Map;
import java.util.Random;

/**
 * claire
 *
 * @param <T>
 */
public class LeshuaRegisterRequest<T> extends LeshuaBasicRequest<T, LeshuaRegisterResponse<T>> {
    private Map<String, File> fileMap;
    private String reqSerialNo = String.valueOf(System.currentTimeMillis() + new Random().nextInt(10));





    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }

    public Map<String, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }
}
