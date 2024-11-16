package com.ttbgz.websocke.server;

import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客户端通道管理类
 * @author ttbgz
 */
public class ChannelHolder {

    public static Map<Integer, Map<String, SocketChannel>> channelGroupMap = new ConcurrentHashMap<>();

    public static void addChannel(String clientId,Integer groupId, SocketChannel channel){
        //先判断 channel组是否存在
        Map<String, SocketChannel> channelMap=channelGroupMap.get(groupId);
        //如果组不存在，先穿件一个组
        if (channelMap==null){
            //创建对象
            Map<String, SocketChannel>  channelMapNew= new ConcurrentHashMap<>();
            channelMapNew.put(clientId, channel);
            //添加进组
            channelGroupMap.put(groupId,channelMapNew);
        }else{
            channelMap.put(clientId, channel);
        }
    }

    public static Map<String, SocketChannel> getChannels(Integer groupId){
        return channelGroupMap.get(groupId);
    }

    public static SocketChannel getChannel(String clientId,Integer groupId){
        Map<String, SocketChannel> channelMap=channelGroupMap.get(groupId);
        if (channelMap==null){
            return null;
        }
        return channelMap.get(clientId);
    }

    public static void removeChannel(String clientId,Integer groupId){
        Map<String, SocketChannel> channelMap=channelGroupMap.get(groupId);
        if (channelMap==null){
            return;
        }
        if (clientId!=null){
            channelMap.remove(clientId);
        }
    }
    public static int getSize(Integer groupId){
        Map<String, SocketChannel> channelMap=channelGroupMap.get(groupId);
        return channelMap.size();

    }

}
