package com.ttbgz.wechat.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 公众号带参临时二维码
 * @author admin
 */
@Getter
@Setter
public class WechatQrCode implements Serializable {
    private static final long serialVersionUID = 5777119669111011584L;
    /**
     * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    private String ticket;
    /**
     * 二维码的有效时间，以秒为单位。最大不超过2592000。
     */
    private int expireSeconds = -1;

    /**
     * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    private String url;

    /**
     * 二维码参数
     */
    private String scene;



}
