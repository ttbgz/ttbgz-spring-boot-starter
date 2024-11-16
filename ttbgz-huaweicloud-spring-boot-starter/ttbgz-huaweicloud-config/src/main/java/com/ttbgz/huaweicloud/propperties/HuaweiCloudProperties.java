package com.ttbgz.huaweicloud.propperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "huawei",ignoreInvalidFields = true)
@Data
public class HuaweiCloudProperties {
    /**
     * appKey
     */
    private String appKey;
    /**
     * accessKeySecret
     */
    private String appSecret;

}
