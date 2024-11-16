package com.ttbgz.huaweicloud.pojo;

import lombok.Data;

/**
 * @author ttbgz
 */
@Data
public class HuaweiSmsResult {

    public HuaweiSmsResult(Integer code,String description,String result) {
        this.code=code;
        this.description=description;
        this.result=result;
    }
    /**
     * 请求返回的结果码。
     */
    private Integer code;
    /**
     * 请求返回的结果码描述。。
     */
    private String description;
    /**
     *短信ID列表，当目的号码存在多个时，每个号码都会返回一个SmsID。
     * 当返回异常响应时不携带此字段。
     */
    private String result;


}
