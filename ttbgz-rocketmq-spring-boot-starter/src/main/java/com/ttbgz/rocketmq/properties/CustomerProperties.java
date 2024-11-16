package com.ttbgz.rocketmq.properties;

import com.ttbgz.rocketmq.enums.MessageListenerEnum;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class CustomerProperties {
    /**
     * topic 名称
     */
    private String topic;
    /**
     * tag名称,默认是 * 即接收 topic下所有的消息
     */
    private String tag;
    /**
     * 消费者组名字
     */
    private String group;
    /**
     * 消费方式(默认并发消费)
     * 生产顺序性： RocketMQ 通过生产者和服务端的协议保障单个生产者串行地发送消息，并按序存储和持久化。如需保证消息生产的顺序性，则必须满足以下条件：
     * 单一生产者： 消息生产的顺序性仅支持单一生产者，不同生产者分布在不同的系统，即使设置相同的分区键，不同生产者之间产生的消息也无法判定其先后顺序。
     * 串行发送：生产者客户端支持多线程安全访问，但如果生产者使用多线程并行发送，则不同线程间产生的消息将无法判定其先后顺序。
     */
    private MessageListenerEnum listenerType=MessageListenerEnum.CONCURRENTLY;
    /**
     * 相同的话只会以第一次创建，后面丢弃
     */
    private String listenerName;
}
