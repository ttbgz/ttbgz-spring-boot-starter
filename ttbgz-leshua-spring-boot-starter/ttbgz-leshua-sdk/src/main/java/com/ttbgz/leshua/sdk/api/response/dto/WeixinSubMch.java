package com.ttbgz.leshua.sdk.api.response.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class WeixinSubMch implements Serializable {
    private String subMchId;
    private String channelId;
    private String msg;
    private String usable;
    private Timestamp createTime;

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
                ", channelId='" + channelId + '\'' +
                ", msg='" + msg + '\'' +
                ", usable='" + usable + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
