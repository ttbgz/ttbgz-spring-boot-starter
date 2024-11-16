package com.ttbgz.leshua.sdk.api.response.dto;

import java.sql.Timestamp;

public class AlipaySubMch {
    private String subMchId;//支付宝商户号
    private String subMchLevel;//支付宝商户号等级
    private String msg;//上报失败时的失败原因
    private String usable;//是否可用
    private Timestamp createTime;//创建时间

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubMchLevel() {
        return subMchLevel;
    }

    public void setSubMchLevel(String channelId) {
        this.subMchLevel = channelId;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "{" +
                "subMchId='" + subMchId + '\'' +
                ", subMchLevel='" + subMchLevel + '\'' +
                ", msg='" + msg + '\'' +
                ", usable='" + usable + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
