package com.ttbgz.aliyun.oss.properties;

import com.aliyun.oss.common.comm.Protocol;
import com.ttbgz.aliyun.properties.AliyunProperties;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ttbgz
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "aliyun.oss",ignoreInvalidFields = true)
public class OssProperties {
    @Resource
    private AliyunProperties aliyunProperties;
    /**
     * 设置OSS服务器地址，默认为https://oss-cn-hangzhou.aliyuncs.com。
     */
    private String endpoint="https://oss-cn-hangzhou.aliyuncs.com";
    /**
     * 设置OSSClient允许打开的最大HTTP连接数，默认为1024个。
     */
    private Integer maxConnections=1024;
    /**
     * 置Socket层传输数据的超时时间，默认为50000毫秒。
     */
    private Integer socketTimeout=50000;
    /**
     * 设置建立连接的超时时间，默认为50000毫秒。
     */
    private Integer connectionTimeout=50000;
    /**
     * 设置从连接池中获取连接的超时时间（单位：毫秒），默认不超时。
     */
    private Integer connectionRequestTimeout;
    /**
     * 设置连接空闲超时时间。超时则关闭连接，默认为60000毫秒。
     */
    private Integer idleConnectionTime=60000;
    /**
     * 设置失败请求重试次数，默认为3次。
     */
    private Integer maxErrorRetry=3;
    /**
     * 设置是否支持将自定义域名作为Endpoint，默认支持。
     */
    private boolean supportCname=true;
    /**
     * 设置是否开启二级域名的访问方式，默认不开启。
     */
    private boolean enabled=false;
    /**
     * 设置是否开启二级域名的访问方式，默认不开启。
     */
    private boolean sldEnabled=false;
    /**
     * 设置连接OSS所使用的协议（HTTP或HTTPS），默认为HTTP。
     */
    private Protocol protocol=Protocol.HTTP;

    /**
     * 设置用户代理，指HTTP的User-Agent头，默认为aliyun-sdk-java。
     */
    private String userAgent;
    /**
     * // 设置代理服务器IP，请将"<yourProxyHost>"替换为代理服务器的IP地址（如"196.128.xxx.xxx"）。
     */
    private String proxyHost;
    /**
     * // 设置代理服务器验证的用户名，请将"<yourProxyUserName>"替换为代理服务器的用户名（如"root"）。
     */
    private String proxyUsername;
    /**
     * // 设置代理服务器验证的密码，请将"<yourProxyPassword>"替换为该用户的验证密码。
     */
    private String proxyPassword;
    /**
     * // 设置是否开启HTTP重定向，默认开启。
     */
    private boolean redirectEnable=true;
    /**
     * // 设置是否开启SSL证书校验，默认开启。
     */
    private boolean verifySslEnable=true;
}
