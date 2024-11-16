package com.ttbgz.leshua.sdk.remote;

import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

@API(method = ApiInvokeMethod.POST, contentType = ApiConstants.APPLICATION_FORM_URLENCODED_VALUE)
public class OpenApiInput extends ApiInput {
    private String billId;
    private String agentId;
    private String sign;
    private String type;
    private String reqSerialNo;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }


    public String getSign() {
        return sign;
    }


    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }
}
