package com.ttbgz.aliyun.oss.config;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.ttbgz.aliyun.oss.properties.OssProperties;
import com.ttbgz.aliyun.oss.service.impl.OssServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 */
@EnableConfigurationProperties(value = {OssProperties.class})
public class AliyunOssConfig {
    @Resource
    OssProperties ossProperties;
    @Bean
    public ClientBuilderConfiguration clientBuilderConfiguration() {
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
        conf.setSignatureVersion(SignVersion.V2);
        // 设置OSSClient允许打开的最大HTTP连接数，默认为1024个。
        conf.setMaxConnections(ossProperties.getMaxConnections());
        // 设置Socket层传输数据的超时时间，默认为50000毫秒。
        conf.setSocketTimeout(ossProperties.getSocketTimeout());
        // 设置建立连接的超时时间，默认为50000毫秒。
        conf.setConnectionTimeout(ossProperties.getConnectionTimeout());
        // 设置从连接池中获取连接的超时时间（单位：毫秒），默认不超时。
        if(ossProperties.getConnectionRequestTimeout()!=null){
            conf.setConnectionRequestTimeout(ossProperties.getConnectionRequestTimeout());
        }

        // 设置连接空闲超时时间。超时则关闭连接，默认为60000毫秒。
        conf.setIdleConnectionTime(ossProperties.getIdleConnectionTime());
        // 设置失败请求重试次数，默认为3次。
        conf.setMaxErrorRetry(ossProperties.getMaxErrorRetry());
        // 设置是否支持将自定义域名作为Endpoint，默认支持。
        conf.setSupportCname(ossProperties.isSupportCname());
        // 设置是否开启二级域名的访问方式，默认不开启。
        conf.setSLDEnabled(ossProperties.isSldEnabled());
        // 设置连接OSS所使用的协议（HTTP或HTTPS），默认为HTTP。
        conf.setProtocol(ossProperties.getProtocol());
        // 设置用户代理，指HTTP的User-Agent头，默认为aliyun-sdk-java。
        if (ossProperties.getUserAgent()!=null){
            conf.setUserAgent(ossProperties.getUserAgent());
        }

        // 设置代理服务器IP，请将"<yourProxyHost>"替换为代理服务器的IP地址（如"196.128.xxx.xxx"）。
        if (ossProperties.getProxyHost()!=null){
            conf.setProxyHost(ossProperties.getProxyHost());
        }
        // 设置代理服务器验证的用户名，请将"<yourProxyUserName>"替换为代理服务器的用户名（如"root"）。
        if (ossProperties.getProxyUsername()!=null){
            conf.setProxyUsername(ossProperties.getProxyUsername());
        }

        // 设置代理服务器验证的密码，请将"<yourProxyPassword>"替换为该用户的验证密码。
        if (ossProperties.getProxyPassword()!=null){
            conf.setProxyPassword(ossProperties.getProxyPassword());
        }

        // 设置是否开启HTTP重定向，默认开启。
        conf.setRedirectEnable(ossProperties.isRedirectEnable());
        // 设置是否开启SSL证书校验，默认开启。
        conf.setVerifySSLEnable(ossProperties.isVerifySslEnable());
        // 自定义重试策略，一般不建议设置。
        // 假设TestRetryStrategy类为您自定义的重试策略，TestRetryStrategy类需要继承RetryStrategy。
        //        conf.setRetryStrategy(new TestRetryStrategy());
        return conf;
    }
    @Bean
    public CredentialsProvider aliyunOssCredentialsProvider() {
        String accessKeyId=ossProperties.getAliyunProperties().getAccessKeyId();
        String accessKeySecret=ossProperties.getAliyunProperties().getAccessKeySecret();
      return  new DefaultCredentialProvider(accessKeyId, accessKeySecret);
    }


    @Bean(name = "oss")
    public OSS ossClient() {

        String endpoint = ossProperties.getEndpoint();
        return new OSSClientBuilder().build(endpoint,aliyunOssCredentialsProvider(), clientBuilderConfiguration());
    }

    @Bean
    public OssServiceImpl ossService() throws Exception {
        return new OssServiceImpl();
    }
}
