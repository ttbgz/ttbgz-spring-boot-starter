package com.ttbgz.xxl.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ttbgz
 */
@ConfigurationProperties(prefix = "xxl.job",ignoreInvalidFields = true)
@Data
public class XxlTokenProperties {
    /**
     * 执行器通讯TOKEN [选填]：非空时启用；
     */
    private String accessToken;
}
