package com.ttbgz.aliyun.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ttbgz
 */
@ConfigurationProperties(prefix = "aliyun",ignoreInvalidFields = true)
@Data
public class AliyunProperties {
    /**
     * accessKeyId
     */
    private String accessKeyId;
    /**
     * accessKeySecret
     */
    private String accessKeySecret;
    /**
     * regionId 区域
     */
    private String regionId="cn-chengdu";

}
