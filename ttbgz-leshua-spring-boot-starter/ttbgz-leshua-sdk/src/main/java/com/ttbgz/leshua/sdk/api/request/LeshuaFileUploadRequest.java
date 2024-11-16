package com.ttbgz.leshua.sdk.api.request;


import com.ttbgz.leshua.sdk.api.response.LeshuaRegisterResponse;

import java.util.Random;

/**
 * @author Claire
 * @date 2022/8/19 20:38
 * @description
 */

/**
 * register-v2/register
 *
 * @param <T>
 * @param <T1>
 */
public class LeshuaFileUploadRequest<T, T1 extends LeshuaRegisterResponse<T>> extends LeshuaBasicRequest<T, T1> {
    private String reqSerialNo = String.valueOf(System.currentTimeMillis() + new Random().nextInt(10));


    //public  Map<String, File> getFileMap();


}
