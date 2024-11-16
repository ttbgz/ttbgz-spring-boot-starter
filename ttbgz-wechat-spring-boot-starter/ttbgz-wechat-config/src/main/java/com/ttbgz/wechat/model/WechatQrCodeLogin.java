package com.ttbgz.wechat.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 公众号带参临时二维码登录参数
 * @author admin
 */
@Getter
@Setter
public class WechatQrCodeLogin implements Serializable {
    private static final long serialVersionUID = 5777119669111011584L;

    /**
     * 用户微信账号
     */
    private String openId;

    /**
     * 二维码参数
     */
    private String scene;



}
