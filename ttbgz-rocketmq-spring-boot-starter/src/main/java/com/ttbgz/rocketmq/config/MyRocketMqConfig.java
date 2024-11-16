package com.ttbgz.rocketmq.config;

import com.ttbgz.rocketmq.properties.RocketMqProperties;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author ttbgz
 */
@Slf4j
@EnableConfigurationProperties(value = {RocketMqProperties.class})
public class MyRocketMqConfig {

    @Resource
    private RocketMqProperties rocketMqProperties;

    @Bean
    @ConditionalOnProperty(prefix = "rocketmq",name = "nameServer")
    DefaultMQProducer defaultMqProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("default-producer-group");
        // 设置NameServer地址
        producer.setNamesrvAddr(rocketMqProperties.getNameServer());
        // 启动producer
        producer.start();
        log.info("default producer start success ...");
        return producer;
    }

}
