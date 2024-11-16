package com.ttbgz.aliyun.config;

import com.ttbgz.aliyun.properties.AliyunProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {AliyunProperties.class})
public class AliyunConfiguration {
}
