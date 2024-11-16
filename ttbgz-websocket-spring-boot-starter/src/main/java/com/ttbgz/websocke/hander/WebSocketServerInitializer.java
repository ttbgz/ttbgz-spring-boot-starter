package com.ttbgz.websocke.hander;

import com.ttbgz.websocke.properties.WebSocketProperties;
import com.ttbgz.websocke.service.WebSocketSecurityService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author ttbgz
 */
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
    private final WebSocketProperties webSocketProperties;
    private final WebSocketSecurityService webSocketSecurityService;
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        // 职责链模式，添加需要处理的Handler
        ChannelPipeline pipeline = ch.pipeline();
        //// http编解码器，websocket 本身是基于http协议的
        pipeline.addLast(new HttpServerCodec());
        // http的 chunked 的消息聚合为完成的请求FullHttpRequest，内容最大长度65535
        pipeline.addLast(new HttpObjectAggregator(65536));
        // WebSocket 数据压缩扩展
        pipeline.addLast(new WebSocketServerCompressionHandler());
        // 权限校验hander 根据业务需求可选
        pipeline.addLast(new WebSocketSecurityHandler(webSocketProperties,webSocketSecurityService));
        // WebSocket 握手、控制帧处理
        pipeline.addLast(new WebSocketServerProtocolHandler(webSocketProperties.getWebsocketPath(), null, true));
        // 通道业务处理hander
        pipeline.addLast(new WebSocketServerHandler());
        // 心跳空闲检测设置
        /*
        说明：IdleStateHandler 是netty提供的处理空闲状态的处理器
            long readerIdleTime:表示多长时间没有读，就会发送一个心跳监测包 检测是否连接
            long writerIdelTime:表示多长时间没有写，就会发送一个心跳监测包 监测是否连接
            long allIdelTime:表示多长时间没有读写，就会发送一个心跳检测包 监测是否连接
            TimeUnit.MINUTES 时间单位
            */
        pipeline.addLast(new IdleStateHandler(webSocketProperties.getReaderIdleTime(),webSocketProperties.getWriterIdleTime(),webSocketProperties.getAllIdleTime(), TimeUnit.SECONDS));
        // 心跳空闲事件处理
        pipeline.addLast(new HeartBeatHandler());
    }

    public WebSocketServerInitializer(WebSocketProperties webSocketProperties,WebSocketSecurityService webSocketSecurityService){
        this.webSocketProperties = webSocketProperties;
        this.webSocketSecurityService=webSocketSecurityService;
    }
}
