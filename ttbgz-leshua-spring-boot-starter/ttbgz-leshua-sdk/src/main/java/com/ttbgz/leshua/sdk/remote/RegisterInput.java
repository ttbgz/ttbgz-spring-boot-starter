package com.ttbgz.leshua.sdk.remote;

import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

/**
 * @author Claire
 * @date 2022/8/22 9:38
 * @description
 */
@API(method = ApiInvokeMethod.POST, contentType = ApiConstants.APPLICATION_FORM_URLENCODED_VALUE)
public class RegisterInput extends ApiInput {
    private String agentId; // 代理商id
    private String sign;    // 签名值
    private String data;    // 数据
    private String version; // 版本号
    private String reqSerialNo; // 流水号

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
