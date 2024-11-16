package com.ttbgz.aliyun.dypls.config;

import com.ttbgz.aliyun.dypls.properties.DyplsProperties;
import com.ttbgz.aliyun.dypls.service.DyplService;
import com.ttbgz.aliyun.dypls.service.impl.DyplServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {DyplsProperties.class})
@Slf4j
public class DyplConfiguration {
    @Resource
    DyplsProperties dyplsProperties;

    @Bean(name = "dyplConfig")
    public com.aliyun.teaopenapi.models.Config dyplConfig(){
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                .setAccessKeyId(dyplsProperties.getAliyunProperties().getAccessKeyId())
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                .setAccessKeySecret(dyplsProperties.getAliyunProperties().getAccessKeySecret());
        // Endpoint 请参考 https://api.aliyun.com/product/Dyplsapi
        config.endpoint =dyplsProperties.getEndpoint();
        return config;
    }
    @Bean
    @ConditionalOnProperty(prefix = "aliyun.dypls", name = "pool-key")
    public DyplService dyplService(){
        return new DyplServiceImpl();
    }

//    @Bean
//    @ConditionalOnProperty(prefix = "aliyun.dypls", name = "msn-enabled",havingValue = "true")
//    public DefaultAlicomMessagePuller defaultAlicomMessagePuller(){
//        DefaultAlicomMessagePuller puller=new DefaultAlicomMessagePuller();
//
//        //设置异步线程池大小及任务队列的大小，还有无数据线程休眠时间
//        puller.setConsumeMinThreadSize(dyplsProperties.getConsumeMinThreadSize());
//        puller.setConsumeMaxThreadSize(dyplsProperties.getConsumeMaxThreadSize());
//        puller.setThreadQueueSize(dyplsProperties.getThreadQueueSize());
//        puller.setPullMsgThreadSize(dyplsProperties.getPullMsgThreadSize());
//        //和服务端联调问题时开启,平时无需开启，消耗性能
//        puller.openDebugLog(false);
//
//        //此处以设置AccessKey ID和AccessKey Secret的环境变量名为：ALIBABA_CLOUD_ACCESS_KEY_ID 、ALIBABA_CLOUD_ACCESS_KEY_SECRET为例。
//        String accessKeyId=dyplsProperties.getAliyunProperties().getAccessKeyId();
//        String accessKeySecret=dyplsProperties.getAliyunProperties().getAccessKeySecret();
//
//        return puller;
//    }

}
