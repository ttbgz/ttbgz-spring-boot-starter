package com.ttbgz.leshua.sdk.api.response.dto;

public class CupsSubMch {
    private String subMchId;//银联cups商户号
    private String msg;//上报失败时的失败原因
    private String usable;//是否可用

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return "{" +
                "subMchId='" + subMchId + '\'' +
                ", msg='" + msg + '\'' +
                ", usable='" + usable + '\'' +
                '}';
    }
}
