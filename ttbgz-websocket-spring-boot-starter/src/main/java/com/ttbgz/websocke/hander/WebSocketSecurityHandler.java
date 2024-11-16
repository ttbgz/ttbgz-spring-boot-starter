package com.ttbgz.websocke.hander;

import com.ttbgz.websocke.enums.SeparatorEnum;
import com.ttbgz.websocke.pojo.ClientInfo;
import com.ttbgz.websocke.properties.WebSocketProperties;
import com.ttbgz.websocke.service.WebSocketSecurityService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ttbgz
 * 客户端权限验证
 */
@Slf4j
public class WebSocketSecurityHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final WebSocketProperties webSocketProperties;
    private final WebSocketSecurityService webSocketSecurityService;
    public WebSocketSecurityHandler(WebSocketProperties webSocketProperties,WebSocketSecurityService webSocketSecurityService){
        this.webSocketProperties=webSocketProperties;
        this.webSocketSecurityService=webSocketSecurityService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

        // 解析客户端的带上来的queryString websocket连接字符串：ws://127.0.0.1:7011/websocket?token=eyJhbGciOiJIUzUxMiJ9...
        // 客户端连接字符串由服务端业务接口下发
        Map<String, String> paramMap = getUrlParams(fullHttpRequest.uri());
        ClientInfo clientInfo =webSocketSecurityService.securityConnect(paramMap);
        if (clientInfo!=null) {
            fullHttpRequest.setUri(webSocketProperties.getWebsocketPath());
            // 客户端业务id放入header，以便后续业务绑定，也可以直接放到channel，ctx.channel().attr(AttributeKey).set(userId);
            fullHttpRequest.headers().set("clientId", clientInfo.getClientId());
            fullHttpRequest.headers().set("groupId", clientInfo.getGroupId());
            // 校验通过之后，传递到下一个hander处理
            channelHandlerContext.fireChannelRead(fullHttpRequest.retain());
            // 只是首次校验，之后消息传递不需要权限校验
            channelHandlerContext.pipeline().remove(WebSocketSecurityHandler.class);
        } else {
            log.error("连接校验不通过");
            channelHandlerContext.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        log.error("error：\r\n" + cause.toString());
    }


    private static Map<String, String> getUrlParams(String url) {
        Map<String, String> map = new HashMap<>(10);
        url = url.replace(SeparatorEnum.QUESTION.getCode(), SeparatorEnum.SEMICOLON.getCode());
        if (!url.contains(SeparatorEnum.SEMICOLON.getCode())) {
            return map;
        }
        if (url.split(SeparatorEnum.SEMICOLON.getCode()).length > 0) {
            String[] arr = url.split(SeparatorEnum.SEMICOLON.getCode())[1].split(SeparatorEnum.AND.getCode());
            for (String s : arr) {
                String key = s.split(SeparatorEnum.EQUALS.getCode())[0];
                String value = s.split(SeparatorEnum.EQUALS.getCode())[1];
                map.put(key, value);
            }
            return map;

        } else {
            return map;
        }
    }
}
