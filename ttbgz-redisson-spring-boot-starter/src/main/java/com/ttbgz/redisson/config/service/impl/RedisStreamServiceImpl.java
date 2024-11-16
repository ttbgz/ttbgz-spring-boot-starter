package com.ttbgz.redisson.config.service.impl;


import com.ttbgz.redisson.config.service.RedisStreamService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.api.stream.StreamCreateGroupArgs;
import org.springframework.stereotype.Service;

/**
 * @author ttbgz
 */
@Service
@Slf4j
public class RedisStreamServiceImpl<T> implements RedisStreamService<T> {
    public RedisStreamServiceImpl(RedissonClient redisson){
        System.out.println("开始初始化");
        this.redisson=redisson;
    }
    /**
     * 队列超时时间
     */
    private Integer queueTime=10;
    private final RedissonClient redisson;


    @Override
    public Long addStream(String queueName, T t) {
        //获取一个流
        RStream<String, T> rStream = redisson.getStream(queueName);
        //创建一个map，添加数据
//        Map<String, T> rr = new HashMap<>();
//        rr.put("xx",t);
//        rStream.add("xx",t);
        StreamAddArgs<String, T> args = StreamAddArgs.entry("xx",t);
        //添加到流
        StreamMessageId streamMessageId =rStream.add(args);
        log.info("getId0:{}",streamMessageId.getId0());
        log.info("getId1:{}",streamMessageId.getId1());
        return streamMessageId.getId0();
    }

    @Override
    public T subStream(String queueName, String groupName, String customerName, int num) {
        //获取一个流
        RStream<String, T> rStream = redisson.getStream(queueName);
        StreamCreateGroupArgs args = StreamCreateGroupArgs.name(groupName).entriesRead(3).id(StreamMessageId.NEWEST).makeStream();
       rStream.createGroup(args);
        return null;
    }


}
