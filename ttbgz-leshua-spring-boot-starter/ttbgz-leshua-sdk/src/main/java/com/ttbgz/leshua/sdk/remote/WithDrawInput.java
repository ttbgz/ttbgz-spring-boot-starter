package com.ttbgz.leshua.sdk.remote;

import com.alibaba.fastjson.JSONObject;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

/**
 * @Author zonghuiTan
 * @Description // 提现接口输入
 **/

@API(method = ApiInvokeMethod.POST)
public class WithDrawInput extends ApiInput {
    private String agentId; // 代理商id
    private String sign;    // 签名
    private JSONObject data; // 数据
    private String version; // 版本号
    private String reqSerialNo; // 流水号，一般随机生成


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


    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
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
}
