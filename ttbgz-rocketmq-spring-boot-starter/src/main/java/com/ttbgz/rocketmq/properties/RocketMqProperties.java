package com.ttbgz.rocketmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author suetian
 */
@Data
@ConfigurationProperties(prefix = "rocketmq",ignoreInvalidFields = true)
public class RocketMqProperties {

    /**
     * nameSrvAddr 地址
     */
    private String nameServer;

    private List<CustomerProperties> customer;

}
