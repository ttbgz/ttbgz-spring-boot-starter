package com.ttbgz.redisson.config.service;

/**
 * @author ttbgz
 */
public interface RedisQueueService<T> {

    /**
     * 发送对象到延迟到队列
     * @param queueName 队列名称
     * @param t 发送对象
     * @param delayTime 延迟时间(单位秒)
     * @return 队列长度
     */
    Integer addOrderDelayQueue(String queueName,T t,Long delayTime);

    /**
     * 获取队列队首元素 take 模式
     * @param queueName 队列名称
     * @return 元素信息
     */
    T getBlockingQueueTake(String queueName);
    /**
     * 获取队列元素Poll 模式
     * @param queueName 队列名称
     * @return 元素信息
     */
    T getBlockingQueuePoll(String queueName);


    /**
     * 发送对象到消息到队列
     * @param queueName 队列名称
     * @param t 发送对象
     * @return 队列长度
     */
    Integer addMessageQueue(String queueName,T t);
    

}
