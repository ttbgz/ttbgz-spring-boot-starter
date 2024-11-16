package com.ttbgz.huaweicloud.config;

import com.ttbgz.huaweicloud.properties.HuaweiSmsProperties;
import com.ttbgz.huaweicloud.service.impl.HuaweiSmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {HuaweiSmsProperties.class})
public class HuaweiSmsConfig {

    @Autowired
    HuaweiSmsProperties huaweiSmsProperties;

//    @Bean(name = "aliyunSmsConfig")
//    public Config aliyunSmsConfig() throws Exception {
//        return new Config()
//                .setAccessKeyId(smsProperties.getAliyunProperties().getAccessKeyId())
//                .setAccessKeySecret(smsProperties.getAliyunProperties().getAccessKeySecret())
//                .setEndpoint(smsProperties.getEndpoint());
//    }

    @Bean
    public HuaweiSmsProperties huaweiSmsProperties() throws Exception {
        return new HuaweiSmsProperties();
    }
//    @Bean
//    public CloseableHttpClient closeableHttpClient(){
//        SSLContext sslContext = null;
//        try {
//            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (x509CertChain, authType) -> true).build();
//        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
//            throw new RuntimeException(e);
//        }
//        return HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)).build();
//    }

    @Bean
    public HuaweiSmsServiceImpl huaweiSmsService(){
        return new HuaweiSmsServiceImpl();
    }
}
