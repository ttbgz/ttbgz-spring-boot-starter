package com.ttbgz.websocke.service;

import com.ttbgz.websocke.pojo.ClientInfo;

import java.util.Map;

/**
 * @author ttbgz
 */
public interface WebSocketSecurityService {

    /**
     * 验证用户
     * @param paramMap 连接参数
     * @return ClientInfo  null 则是验证失败，成功返回对应信息
     */
    ClientInfo securityConnect(Map<String, String> paramMap);

}
