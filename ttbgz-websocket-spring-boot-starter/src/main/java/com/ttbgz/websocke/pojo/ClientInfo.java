package com.ttbgz.websocke.pojo;

import lombok.Data;

/**
 * 客户信息
 * @author ttbgz
 */
@Data
public class ClientInfo {
    /**
     * 客户唯一识别编号
     */
    private String clientId;
    /**
     * 消息组，默认为0 比如多端通讯，需要识别哪个端
     */
    private Integer groupId=0;

    public ClientInfo(){
        this.groupId=0;
    }
    public ClientInfo(String clientId,Integer groupId){
        this.clientId=clientId;
        this.groupId=groupId;
    }
}
