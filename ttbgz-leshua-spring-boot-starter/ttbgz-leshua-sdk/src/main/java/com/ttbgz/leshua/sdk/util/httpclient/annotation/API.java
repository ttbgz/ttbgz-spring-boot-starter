/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient.annotation;


import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

import java.lang.annotation.*;

/**
 * 外调API接口注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface API {

    /**
     * 访问地址
     *
     * @return
     */
    String url() default "";

    /**
     * 编码格式
     *
     * @return
     */
    String charset() default "UTF-8";

    /**
     * 请求方式
     *
     * @return
     */
    String contentType() default ApiConstants.APPLICATION_JSON_VALUE;

    /**
     * 接口调用方式
     *
     * @return
     */
    ApiInvokeMethod method() default ApiInvokeMethod.POST;
}
