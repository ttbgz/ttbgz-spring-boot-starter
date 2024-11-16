package com.ttbgz.websocke.server;


import com.ttbgz.websocke.hander.WebSocketServerInitializer;
import com.ttbgz.websocke.properties.WebSocketProperties;
import com.ttbgz.websocke.service.WebSocketSecurityService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ttbgz
 */
@Slf4j
@Service
public class NettyWebSocketServer implements CommandLineRunner, DisposableBean{
    @Resource
    private WebSocketProperties webSocketProperties;
    @Resource
    private WebSocketSecurityService webSocketSecurityService;
    //创建线程池执行器
    //主事件循环组（mainGroup）负责接受客户端连接请求，并将连接分配给工作事件循环组（workerGroup）中的线程进行处理。通常情况下，主事件循环组只需要一个线程即可。
    private final EventLoopGroup mainGroup = new NioEventLoopGroup();
    //工作事件循环组（workerGroup）负责实际的I/O操作，例如读取、写入和处理数据。
    // 工作事件循环组的线程数通过NettyRuntime.availableProcessors()来方法获取系统可用处理器的数量 设置为可用的处理器核心数，这样可以充分利用系统资源。
    private final EventLoopGroup workerGroup = new NioEventLoopGroup(NettyRuntime.availableProcessors());
    /**
     * 销毁
     */
    @Override
    public void destroy() throws ExecutionException, InterruptedException {
        Future<?> futureMainGroup = mainGroup.shutdownGracefully();
        Future<?> futureWorkerGroup = workerGroup.shutdownGracefully();
        futureMainGroup.get();
        futureWorkerGroup.get();
        log.info("关闭 ws sever 成功！！！");
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("websocket启动中.....");
        //服务器启动引导对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup, workerGroup)
                //设置nio的双向通道
                .channel(NioServerSocketChannel.class)
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, webSocketProperties.getSoBacklog())
                //设置保持活动连接状态 相当于心跳机制，默认为7200s
                .option(ChannelOption.SO_KEEPALIVE, true)
                // 为 serverBootstrap 添加日志处理器
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new WebSocketServerInitializer(webSocketProperties,webSocketSecurityService));
        serverBootstrap.bind(webSocketProperties.getPort()).sync();
    }
}
