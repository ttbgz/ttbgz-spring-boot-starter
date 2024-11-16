package com.ttbgz.redisson.config.service;

/**
 * @author ttbgz
 */
public interface RedisStreamService<T> {

    /**
     * 发送对象到延迟到队列
     * @param queueName 队列名称
     * @param t 发送对象
     * @return 队列长度
     */
    Long addStream(String queueName,T t);


    /**
     * 发送对象到延迟到队列
     * @param queueName 队列名称
     * @return 队列长度
     */
    T subStream(String queueName,String groupName,String customerName,int num);
}
