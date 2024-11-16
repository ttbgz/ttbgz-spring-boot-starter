package com.ttbgz.wechat.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 微信公众号配置对象
 * 
 * @author 1299
 * @date 2024-08-05
 */
@Getter
@Setter
public class WechatMaConfigure implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** AppID */
    private String appId;

    /** 秘钥 */
    private String secret;

    /** Token */
    private String token;

    /** AES密钥 */
    private String encodingAesKey;


}
