/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口访问方式
 */
public enum ApiInvokeMethod {
    GET, POST, PUT, DELETE;

    private static Map<String, ApiInvokeMethod> map = new HashMap<>();

    static {
        for (ApiInvokeMethod apiMethod : ApiInvokeMethod.values()) {
            map.put(apiMethod.name().toUpperCase(), apiMethod);
        }
    }

    public static ApiInvokeMethod fromString(String methodStr) {
        if(StringUtils.isEmpty(methodStr)){
            return null;
        }
        return map.get(methodStr.toUpperCase());
    }
}
