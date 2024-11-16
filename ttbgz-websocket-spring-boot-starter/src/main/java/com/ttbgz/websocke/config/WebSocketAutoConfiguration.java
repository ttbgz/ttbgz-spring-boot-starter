package com.ttbgz.websocke.config;

import com.ttbgz.websocke.properties.WebSocketProperties;
import com.ttbgz.websocke.server.NettyWebSocketServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author ttbgz
 */
@EnableConfigurationProperties(value = {WebSocketProperties.class})
public class WebSocketAutoConfiguration {

    /**
     * 如果没有配置，websocket_path 则不初始化websocket
     *  havingValue = "true" 如果是 boolean 类型，可以直接判断
     *  不写的话，表示配置了属性值，则默认为 true
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "socket", name = "websocket-path")
    public NettyWebSocketServer webSocketServer(){
        return new NettyWebSocketServer();
    }



}
