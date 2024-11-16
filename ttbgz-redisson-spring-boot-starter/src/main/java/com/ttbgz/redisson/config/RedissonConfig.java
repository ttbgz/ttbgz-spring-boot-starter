package com.ttbgz.redisson.config;

import com.ttbgz.redisson.config.service.impl.RedisQueueServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author ttbgz
 */
@Configuration
public class RedissonConfig {
    /**
     *  Redis 部署模式的枚举类型
     */
    public enum RedisDeploymentMode {
        SINGLE, CLUSTER, SENTINEL,NULL
    }


    /**
     * 单机模式的连接参数
     */
    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private int port;

    @Value("${spring.data.redis.password:''}")
    private String password;

    /**
     * 集群模式的连接参数
     */
    @Value("${spring.data.redis.cluster.nodes:''}")
    private String clusterNodes;

    /**
     * 哨兵模式的连接参数
     */
    @Value("${spring.data.redis.sentinel.master:''}")
    private String masterName;

    @Value("${spring.data.redis.sentinel.nodes:''}")
    private String sentinelNodes;

    public RedisDeploymentMode getDeploymentMode() {
        if (StringUtils.isNotBlank(host)){
            return RedisDeploymentMode.SINGLE;
        }
        if (StringUtils.isNotBlank(sentinelNodes)){
            return RedisDeploymentMode.SENTINEL;
        }
        if (StringUtils.isNotBlank(clusterNodes)){
            return RedisDeploymentMode.CLUSTER;
        }
        return RedisDeploymentMode.NULL;
    }

    /**
     * Spring容器销毁时，调用RedissonClient对象的shutdown方法进行资源释放。
     * @return RedissonClient
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){

        Config config = new Config();
        boolean passWordStatus=StringUtils.isNotBlank(password);

        switch (getDeploymentMode()) {
            case SINGLE:
                SingleServerConfig singleServerConfig=config.useSingleServer();
                singleServerConfig.setAddress("redis://" + host + ":" + port);
                if (passWordStatus){
                    singleServerConfig.setPassword(password);
                }
                break;

            case CLUSTER:
                ClusterServersConfig clusterServersConfig=config.useClusterServers();
                clusterServersConfig.addNodeAddress(clusterNodes.split(","));
                if (passWordStatus){
                    clusterServersConfig.setPassword(password);
                }
                break;

            case SENTINEL:
                SentinelServersConfig sentinelServersConfig=config.useSentinelServers();

                sentinelServersConfig.setMasterName(masterName);
                sentinelServersConfig.addSentinelAddress(sentinelNodes.split(","));
                if (passWordStatus){
                    sentinelServersConfig.setPassword(password);
                }
                break;

            default:
                throw new IllegalArgumentException("Unknown deployment mode");
        }
//        StringCodec codec = new StringCodec();
//        config.setCodec(codec);
        return Redisson.create(config);
    }

    @Bean
    @DependsOn("redissonClient")
    public RedisQueueServiceImpl redisQueueServiceImpl(){
        return new RedisQueueServiceImpl(redissonClient());
    }
//    @Bean
//    @DependsOn("redissonClient")
//    public RedisStreamServiceImpl redisStreamServiceImpl(){
//        return new RedisStreamServiceImpl(redissonClient());
//    }
}
