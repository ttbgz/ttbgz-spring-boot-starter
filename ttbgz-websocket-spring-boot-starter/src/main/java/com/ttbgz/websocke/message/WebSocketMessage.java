package com.ttbgz.websocke.message;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class WebSocketMessage {
    /**
     * 消息类型，0 心跳，1 文本
     */
    private int type;
    /**
     * 消息内容
     */
    private String content;
}
