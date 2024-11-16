package com.ttbgz.rocketmq.enums;

/**
 * 消费者类型
 * @author ttbgz
 */
public enum MessageListenerEnum {
    /*同时消费*/
    CONCURRENTLY,
    /*顺序*/
    ORDERLY;
}
