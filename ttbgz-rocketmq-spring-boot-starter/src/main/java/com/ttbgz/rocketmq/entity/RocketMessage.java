package com.ttbgz.rocketmq.entity;

import lombok.Data;

/**
 * @author ttbgz
 */
@Data
public class RocketMessage {
    /**
     * 消息内容
     */
    private String body;
    /**
     * 消息id
     */
    private String msgId;

    public RocketMessage(String msgId, String body)
    {
        this.body = body;
        this.msgId = msgId;
    }
}
