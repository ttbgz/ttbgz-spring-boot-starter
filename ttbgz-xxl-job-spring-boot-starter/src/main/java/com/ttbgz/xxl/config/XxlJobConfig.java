package com.ttbgz.xxl.config;

import com.ttbgz.xxl.properties.XxlAdminProperties;
import com.ttbgz.xxl.properties.XxlExecutorProperties;
import com.ttbgz.xxl.properties.XxlTokenProperties;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
//@Configuration
@EnableConfigurationProperties(value = {XxlAdminProperties.class, XxlExecutorProperties.class, XxlTokenProperties.class})
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);


    @Autowired XxlAdminProperties xxlAdminProperties;
    @Autowired XxlExecutorProperties xxlExecutorProperties;
    @Autowired XxlTokenProperties xxlTokenProperties;

    /**
     * 如果没有配置，websocket_path 则不初始化websocket
     *  havingValue = "true" 如果是 boolean 类型，可以直接判断
     *  不写的话，表示配置了属性值，则默认为 true
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "xxl.job.admin", name = "admin-addresses")
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(xxlAdminProperties.getAdminAddresses());
        xxlJobSpringExecutor.setAppname(xxlExecutorProperties.getAppname());
        xxlJobSpringExecutor.setAddress(xxlExecutorProperties.getAddress());
        xxlJobSpringExecutor.setIp(xxlExecutorProperties.getIp());
        xxlJobSpringExecutor.setPort(xxlExecutorProperties.getPort());
        xxlJobSpringExecutor.setAccessToken(xxlTokenProperties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(xxlExecutorProperties.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(xxlExecutorProperties.getLogRetentionDays());

        return xxlJobSpringExecutor;
    }

    /**
     * 针对多网卡、容器内部署等情况，可借助 "spring-cloud-commons" 提供的 "InetUtils" 组件灵活定制注册IP；
     *
     *      1、引入依赖：
     *          <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-commons</artifactId>
     *             <version>${version}</version>
     *         </dependency>
     *
     *      2、配置文件，或者容器启动变量
     *          spring.cloud.inetutils.preferred-networks: 'xxx.xxx.xxx.'
     *
     *      3、获取IP
     *          String ip_ = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
     */


}