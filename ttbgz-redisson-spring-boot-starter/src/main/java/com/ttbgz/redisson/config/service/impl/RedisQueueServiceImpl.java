package com.ttbgz.redisson.config.service.impl;


import com.ttbgz.redisson.config.service.RedisQueueService;
import org.redisson.api.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ttbgz
 */
@Service
public class RedisQueueServiceImpl<T> implements RedisQueueService<T> {
    public RedisQueueServiceImpl(RedissonClient redisson){
        System.out.println("开始初始化");
        this.redisson=redisson;
    }
    /**
     * 队列超时时间
     */
    private Integer queueTime=10;
    private final RedissonClient redisson;

    /**
     * 发送订单到延迟到队列
     * @return messageId
     */
    @Override
    public Integer addOrderDelayQueue(String queueName,T t,Long delayTime) {

        if (t == null){
            throw new RuntimeException("发送到队列失败，没有对象参数");
        }
        return this.addOrderDelayQueueExecute(queueName,t,delayTime,TimeUnit.SECONDS);
    }

    @Override
    public T getBlockingQueueTake(String queueName) {
        if (queueName == null){
            throw new RuntimeException("队列名称不能为空");
        }
        RBlockingQueue<T> queue = redisson.getBlockingQueue(queueName);
        if (queue != null){
            try {
                return queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("队列获取失败");
            }
        }
        return null;
    }

    @Override
    public T getBlockingQueuePoll(String queueName) {
        if (queueName == null){
            throw new RuntimeException("队列名称不能为空");
        }
        RBlockingQueue<T> queue = redisson.getBlockingQueue(queueName);
        if (queue != null){
            try {
                return queue.poll(queueTime,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("队列获取失败");
            }
        }
        return null;
    }

    @Override
    public Integer addMessageQueue(String queueName, T t) {
        if (t == null){
            throw new RuntimeException("发送订单匹配失败!参数不完整!");
        }
        RBlockingQueue<T> queue = redisson.getBlockingQueue(queueName);
        queue.add(t);
        return queue.size();
    }

    /**
     *
     * @param queueName 队列名称
     * @param t 消息对象
     * @param delayTime 延迟时间
     * @param timeUnit 延迟单位
     * @return
     */
    private Integer addOrderDelayQueueExecute(String queueName, T t, Long delayTime, TimeUnit timeUnit) {
        if (t == null){
            throw new RuntimeException("发送到队列失败，没有对象参数");
        }
        RBlockingQueue<T> queue = redisson.getBlockingQueue(queueName);
        RDelayedQueue<T> delayQueue = redisson.getDelayedQueue(queue);

        delayQueue.offer(t,delayTime,timeUnit);
        return delayQueue.size();
    }
}
