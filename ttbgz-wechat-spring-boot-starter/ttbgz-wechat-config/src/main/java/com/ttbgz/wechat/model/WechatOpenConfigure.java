package com.ttbgz.wechat.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 微信开放平台配置对象
 * 
 * @author 1299
 * @date 2024-08-05
 */
@Getter
@Setter
public class WechatOpenConfigure implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 设置微信开放平台的appid.
     */
    private String appId;

    /**
     * 设置微信开放平台的app secret.
     */
    private String secret;

    /**
     * 设置微信开放平台的token.
     */
    private String token;

    /**
     * 设置微信开放平台的EncodingAESKey.
     */
    private String aesKey;


}
