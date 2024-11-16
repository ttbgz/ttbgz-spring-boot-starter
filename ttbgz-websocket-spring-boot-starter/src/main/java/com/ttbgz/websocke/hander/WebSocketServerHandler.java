package com.ttbgz.websocke.hander;

import com.alibaba.fastjson2.JSON;
import com.ttbgz.websocke.message.WebSocketMessage;
import com.ttbgz.websocke.pojo.ClientInfo;
import com.ttbgz.websocke.pojo.MsgResult;
import com.ttbgz.websocke.server.ChannelHolder;
import com.ttbgz.websocke.utils.SocketUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 *
 * @author ttbgz
 * BinaryWebSocketFrame //二进制的消息帧
 * CloseWebSocketFrame  //关闭连接的控制帧
 * ContinuationWebSocketFrame //表示消息中多于一个帧的标识
 * PingWebSocketFrame //客户端发送的心跳帧
 * PongWebSocketFrame //服务端响应的心跳帧
 * TextWebSocketFrame //文本的消息帧
 */
@Slf4j
public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    /**
     * 消息处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame webSocketFrame) throws Exception {
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            CloseWebSocketFrame closeFrame = (CloseWebSocketFrame) webSocketFrame;
            log.info("client id: {},close reason:{} ", ctx.channel().id().asShortText(), closeFrame.reasonText());
            return;
        }

        if (webSocketFrame instanceof PingWebSocketFrame) {
            ctx.write(new PongWebSocketFrame(webSocketFrame.content().retain()));
            return;
        }

        if (webSocketFrame instanceof TextWebSocketFrame) {
            String request = ((TextWebSocketFrame) webSocketFrame).text();
//            log.info("client_id:{} channel id:{} input:{}", SocketUtil.getChannelClientId(ctx.channel()),ctx.channel().id().asShortText() ,request);
            try {
                WebSocketMessage webSocketMessage= JSON.parseObject(request, WebSocketMessage.class);
                if (webSocketMessage.getType()==0){
                    ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(MsgResult.newInstance(0,"success"))));
                }else{
                    // 非心跳包的处理，根据自己业务扩展
                    //暂时没有业务需求，暂时返回一个字符串
                   // ctx.channel().writeAndFlush(new TextWebSocketFrame("hello js!!!"));
                }

            }catch (Exception e){

            }
            return;
        }
        //二进制消息
        if (webSocketFrame instanceof BinaryWebSocketFrame) {
            ctx.write(webSocketFrame.retain());
        }
    }

    /**
     * 当连接建立并准备好接收数据时，这个方法会被调用。你可以在这里添加处理器到 ChannelPipeline 中，或者开始发送数据。
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("Client connected: " + ctx.channel());
    }
    /**
     * 当连接关闭时，这个方法会被调用。你可以在这里执行清理操作，如关闭资源或发送断开连接的确认消息。
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * 触发时机：当ChannelHandler被添加到ChannelPipeline中时，该方法会被调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 当处理器被添加到ChannelPipeline时调用
        System.out.println("WebSocket client connected.处理器被添加到ChannelPipeline时调用");
    }

    /**
     * 当处理器从ChannelPipeline中移除时调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当处理器从ChannelPipeline中移除时调用
        System.out.println("WebSocket client disconnected. 理器从ChannelPipeline中移除时调用");
        ClientInfo clientInfo = Optional.ofNullable(SocketUtil.getChannelClientId(ctx.channel())).orElseGet(ClientInfo::new);
        ChannelHolder.removeChannel(clientInfo.getClientId(),clientInfo.getGroupId());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        // 握手完成事件，表示http协议成功升级为websockt协议
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete handshakeCompletedEvent) {
            // 握手请求头
            HttpHeaders headers = handshakeCompletedEvent.requestHeaders();
            String clientId = headers.get("clientId");
            Integer groupId = Integer.valueOf(headers.get("groupId"));
            ClientInfo clientInfo=new ClientInfo();
            channel.attr(SocketUtil.userIdKey).set(clientInfo);
            ChannelHolder.addChannel(clientId,groupId, channel);
        }
    }
    /**
     * 当发生异常时调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("error：\r\n" + cause.toString());
        // 当发生异常时调用
        cause.printStackTrace();
        ctx.close();
    }

}
