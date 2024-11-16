package com.ttbgz.huaweicloud.config;

import com.ttbgz.huaweicloud.propperties.HuaweiCloudProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {HuaweiCloudProperties.class})
public class HuaweiCloudConfiguration {


}
