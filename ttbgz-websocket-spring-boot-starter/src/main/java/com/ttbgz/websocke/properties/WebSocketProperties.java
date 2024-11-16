package com.ttbgz.websocke.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ttbgz
 */
@ConfigurationProperties(prefix = "socket",ignoreInvalidFields = true)
@Data
public class WebSocketProperties {
    /**
     * websocket路径
     */
    private String websocketPath;
    /**
     * websocket 端口
     */
    private Integer port=8090;
    /**
     * 表示多长时间没有读，就会发送一个心跳监测包 检测是否连接 单位(秒)
     */
    private long readerIdleTime=30;
    /**
     * 表示多长时间没有写，就会发送一个心跳监测包 监测是否连接 单位(秒)
     */
    private long writerIdleTime=30;
    /**
     * 表示多长时间没有读写，就会发送一个心跳检测包 监测是否连接 单位(秒)
     */
    private long allIdleTime=60;
    /**
     * 积压队列大小
     */
    private Integer soBacklog=128;
}
