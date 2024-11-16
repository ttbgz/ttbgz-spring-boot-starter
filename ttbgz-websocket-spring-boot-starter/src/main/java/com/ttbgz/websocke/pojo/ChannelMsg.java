package com.ttbgz.websocke.pojo;

import com.alibaba.fastjson2.JSON;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChannelMsg<T> {
    /**
     * 消息组id
     */
    private Integer groupId;

    private String context;

    public static <T> ChannelMsg<T> newInstance(int groupId,T content) {
        return ChannelMsg.<T>builder()
                .groupId(groupId)
                .context(JSON.toJSONString(content))
                .build();
    }
}
