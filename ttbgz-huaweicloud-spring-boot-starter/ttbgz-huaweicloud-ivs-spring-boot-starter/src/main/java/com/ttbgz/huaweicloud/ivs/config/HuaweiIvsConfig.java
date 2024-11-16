package com.ttbgz.huaweicloud.ivs.config;

import com.ttbgz.huaweicloud.ivs.properties.HuaweiIvsProperties;
import com.ttbgz.huaweicloud.ivs.service.impl.HuaweiIvsServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {HuaweiIvsProperties.class})
public class HuaweiIvsConfig {

//    @Autowired
//    HuaweiIvsProperties huaweiIvsProperties;

    @Bean
    public HuaweiIvsProperties huaweiIvsProperties() throws Exception {
        return new HuaweiIvsProperties();
    }

    @Bean
    public HuaweiIvsServiceImpl huaweiIvsServiceImpl(){
      return new HuaweiIvsServiceImpl();
    }

}
