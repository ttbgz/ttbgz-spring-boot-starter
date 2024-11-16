package com.ttbgz.rocketmq.service.impl;


import com.alibaba.fastjson.JSON;
import com.ttbgz.rocketmq.enums.TimeLevelEnum;
import com.ttbgz.rocketmq.service.RocketMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rocketMq 消息发送
 * @author ttbgz
 */
@Service
@Slf4j
public class RocketMessageServiceImpl<T> implements RocketMessageService<T> {
    @Autowired
    private DefaultMQProducer defaultMqProducer;
    private SendResult syncOrdinaryMessageExecute(String topic, String tag, T t, TimeLevelEnum timeLevelEnum){
        Message msg = new Message(topic, JSON.toJSONString(t).getBytes());
        if (StringUtils.isNotBlank(tag)){
            msg.setTags(tag);
        }

        //延迟投递
        if (timeLevelEnum != null){
            msg.setDelayTimeLevel(timeLevelEnum.getLevel());
        }

        try {
            // 利用producer进行发送，并同步等待发送结果
            SendResult result= defaultMqProducer.send(msg);
            if (result.getSendStatus() != SendStatus.SEND_OK){
                throw new RuntimeException(topic+ "发送消息失败");
            }
            return result;
        } catch (MQClientException e) {
            log.error("rocketMq 连接异常:",e);
            throw new RuntimeException(e);
        } catch (RemotingException e) {
            log.error("rocketMq 远程操作异常:",e);
            throw new RuntimeException(e);
        } catch (MQBrokerException e) {
            log.error("rocketMq MQBroker连接异常:",e);
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            log.info("发送消息被中断",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public SendResult sendSyncOrdinaryMessage(String topic, T t) {
        return this.syncOrdinaryMessageExecute(topic,null,t,null);
    }

    @Override
    public SendResult sendSyncOrdinaryMessage(String topic, String tag, T t) {
        return this.syncOrdinaryMessageExecute(topic,tag,t,null);
    }

    @Override
    public SendResult sendDelayOrdinaryMessage(String topic, T t, TimeLevelEnum timeLevelEnum) {
        return this.syncOrdinaryMessageExecute(topic,null,t,timeLevelEnum);
    }

    @Override
    public SendResult sendDelayOrdinaryMessage(String topic, String tag, T t,TimeLevelEnum timeLevelEnum) {
        return this.syncOrdinaryMessageExecute(topic,tag,t,timeLevelEnum);
    }



}
