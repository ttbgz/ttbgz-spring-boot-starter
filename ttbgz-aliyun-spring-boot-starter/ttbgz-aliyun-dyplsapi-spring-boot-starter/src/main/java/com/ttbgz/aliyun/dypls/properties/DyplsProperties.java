package com.ttbgz.aliyun.dypls.properties;

import com.ttbgz.aliyun.properties.AliyunProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.annotation.Resource;


/**
 * @author ttbgz
 * @date 2021/12/6
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "aliyun.dypls",ignoreInvalidFields = true)
public class DyplsProperties {

    @Resource private AliyunProperties aliyunProperties;

    /**
     * 号码池Key
     */
    private String poolKey;
    /**
     * endpoint 站点区域
     */
    private String endpoint="dyplsapi.aliyuncs.com";
}
