package com.ttbgz.huaweicloud.ivs.properties;

import com.ttbgz.huaweicloud.propperties.HuaweiCloudProperties;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author ttbgz
 * @date 2021/12/6
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "huawei.ivs",ignoreInvalidFields = true)
public class HuaweiIvsProperties {

    @Resource private HuaweiCloudProperties huaweiCloudProperties;
    /**
     * 区域：配置购买的区域 列如 : cn-north-1
     *
     */
    private String region;
}
