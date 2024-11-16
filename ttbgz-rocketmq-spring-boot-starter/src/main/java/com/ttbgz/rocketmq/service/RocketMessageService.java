package com.ttbgz.rocketmq.service;


import com.ttbgz.rocketmq.enums.TimeLevelEnum;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * rocketMq 消息发送
 * @author ttbgz
 */
public interface RocketMessageService<T> {
    /**
     * 同步发送普通消息
     * @param topic 消息主题
     * @param t 消息内容
     * @return 发送结果
     */
    SendResult sendSyncOrdinaryMessage(String topic,T t);
    /**
     * 同步发送普通消息
     * @param topic 消息主题
     * @param tag tag标签
     * @param t 消息内容
     * @return 发送结果
     */
    SendResult sendSyncOrdinaryMessage(String topic, String tag, T t);

    /**
     * 同步发送普通消息
     * @param topic 消息主题
     * @param t 消息内容
     * @param timeLevelEnum mq延迟等级
     * @return 发送结果
     */
    SendResult sendDelayOrdinaryMessage(String topic, T t, TimeLevelEnum timeLevelEnum);
    /**
     * 同步发送普通消息
     * @param topic 消息主题
     * @param tag tag标签
     * @param t 消息内容
     * @param timeLevelEnum mq延迟等级
     * @return 发送结果
     */
    SendResult sendDelayOrdinaryMessage(String topic, String tag, T t,TimeLevelEnum timeLevelEnum);
}
