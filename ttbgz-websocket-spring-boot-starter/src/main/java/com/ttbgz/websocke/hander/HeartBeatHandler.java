package com.ttbgz.websocke.hander;

import com.ttbgz.websocke.pojo.ClientInfo;
import com.ttbgz.websocke.utils.SocketUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;


/**
 * websocket 空间时间监听
 * @author ttbgz
 */
@Slf4j
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent idleStateEvent) {
            Channel channel = ctx.channel();
            ClientInfo clientInfo = SocketUtil.getChannelClientId(channel);
            // 读空闲
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                // 写空闲
            } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                // 读写空闲
            } else if (idleStateEvent.state() == IdleState.ALL_IDLE) {
                //关闭socket 链接
                SocketUtil.closeChannel(channel);
            }
        }
    }
}