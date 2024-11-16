package com.ttbgz.websocke.utils;

import com.alibaba.fastjson2.JSONObject;
import com.ttbgz.websocke.pojo.ChannelMsg;
import com.ttbgz.websocke.pojo.ClientInfo;
import com.ttbgz.websocke.pojo.MsgResult;
import com.ttbgz.websocke.server.ChannelHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SocketUtil {

    public static AttributeKey<ClientInfo> userIdKey = AttributeKey.valueOf("userId");

    /**
     * 单对单发送推送消息
     * @param clientId 客户id
     * @param groupId 组编号
     * @param content 内容
     * @param <T>
     */
    public static <T> void pushMsgToOne(String clientId,int groupId, T content) {
        SocketChannel channel = ChannelHolder.getChannel(clientId,groupId);
        if (channel == null) {
            log.error("clientId:{} is not exist", clientId);
            return ;
        }
        ChannelMsg<T> channelMsg = ChannelMsg.newInstance(groupId,content);
        send(channel, channelMsg);
    }

    /**
     * 向组全体发送消息
     * @param groupId 组编号
     * @param msg 消息 内容
     * @param <T>
     */
    public static <T> void pushMsgGroupToAll(int groupId,T msg) {
        Map<String, SocketChannel> channelMap= ChannelHolder.getChannels(groupId);
        if (channelMap==null){
            return ;
        }
        for (SocketChannel value : channelMap.values()) {
            ChannelMsg<T> channelMsg = ChannelMsg.newInstance(groupId,msg);
            send(value, channelMsg);
        }
    }

    /**
     * 发送消息实现方法
     * @param channel 消息管道
     * @param channelMsg 消息内容
     * @param <T>
     */
    private static <T> void send(SocketChannel channel, ChannelMsg<T> channelMsg) {
        ClientInfo clientInfo = getChannelClientId(channel);
        if (channel.isActive()) {
            String content = JSONObject.toJSONString(MsgResult.newInstance(1,channelMsg.getContext()));
            channel.writeAndFlush(new TextWebSocketFrame(content)).addListener((ChannelFutureListener) channelFuture -> {
                if (channelFuture.isSuccess()) {
                    boolean b = true;
                } else {
                    log.error("send msg to user:{} failed,content:{}",clientInfo.getClientId(),JsonUtil.toString(channelMsg));
                    closeChannel(channel);
                }
            });
        } else {
            closeChannel(channel);
        }
    }

    public static void closeChannel(Channel channel) {
        channel.close();
        ClientInfo clientInfo = getChannelClientId(channel);
        ChannelHolder.removeChannel(clientInfo.getClientId(),clientInfo.getGroupId());
    }

    /**
     * 获取管道存取对象
     * @param channel 消息管道
     * @return ClientInfo 存取对象信息
     */
    public static ClientInfo getChannelClientId(Channel channel) {
        return channel.attr(userIdKey).get();
    }

}