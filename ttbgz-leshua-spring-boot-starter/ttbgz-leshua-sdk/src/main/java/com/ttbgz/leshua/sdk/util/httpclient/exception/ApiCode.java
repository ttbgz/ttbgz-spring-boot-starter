/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient.exception;

/**
 * 接口调用异常代码
 * @author yehl
 * @date 2018年4月24日 下午5:11:32
 */
public class ApiCode {

    /** 业务数据异常 **/
    public static final String API_ERROR = "9001";
    /** 请求被阻止 **/
    public static final String API_STOP_REQUEST = "9002";
    /** 接口输入参数未使用API注解异常 **/
    public static final String API_ANNOTATION_NOT_EXIST = "9003";
    /** 接口调用方式未配置异常 **/
    public static final String API_METHOD_NOT_EXIST = "9004";
    /** 接口调用地址占位符格式异常 **/
    public static final String API_PLACEHOLDER_INVALID = "9005";
}
