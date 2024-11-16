package com.ttbgz.rocketmq.consumer;

import com.ttbgz.rocketmq.entity.MethodWithBean;
import com.ttbgz.rocketmq.entity.RocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;
/**
 * @author ttbgz
 */
@Slf4j
public class ConsumerConcurrently {
    /**
     * 创建并发消费
     * @param nameServer rocketmq地址
     * @param topic topic
     * @param tag tag
     * @param group 消费组
     */
    public ConsumerConcurrently(String nameServer, String topic, String tag, String group, MethodWithBean methodWithBean) throws MQClientException{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group,true);

        // 设置NameServer地址
        consumer.setNamesrvAddr(nameServer);
        //订阅一个或多个topic，并指定tag过滤条件，这里指定*表示接收所有tag的消息
        consumer.subscribe(topic, StringUtils.isNotBlank(tag)?tag:"*");
        //默认集群模式,同一个消费组内的消费者分担消费  通过以下代码来设置采用广播模式，广播模式下，消费组内的每一个消费者都会消费全量消息。
        // consumer.setMessageModel(MessageModel.BROADCASTING);
        //注册回调接口来处理从Broker中收到的消息 并发消费
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                //消费消息
                for (MessageExt messageExt : msgs) {
                    try {
                        String topic = messageExt.getTopic();
                        String tags = messageExt.getTags();
                        String body = new String(messageExt.getBody(),RemotingHelper.DEFAULT_CHARSET);
                        RocketMessage rocketMessage=new RocketMessage(messageExt.getMsgId(),body);
                        //调用具体消费流程
//                        log.info("MQ消息topic={}, tags={}, 消息内容={}", topic, tags, body);
                        methodWithBean.getMethod().invoke(methodWithBean.getBean(), rocketMessage);
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    } catch (Exception e) {
                        log.error("获取MQ消息内容异常", e);
                        //暂停当前队列
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }

                // 返回消息消费状态，ConsumeConcurrentlyStatus.CONSUME_SUCCESS为消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动Consumer
        consumer.start();
        log.info("consumer {} Started...",methodWithBean.getMethod().getName());
    }
}
