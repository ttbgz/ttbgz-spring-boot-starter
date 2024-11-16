package com.ttbgz.wechat.service;

import com.ttbgz.wechat.exception.AesException;
import com.ttbgz.wechat.model.WechatMaConfigure;
import com.ttbgz.wechat.model.WechatMpConfigure;
import com.ttbgz.wechat.model.WechatQrCode;
import com.ttbgz.wechat.model.WechatQrCodeLogin;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 微信公众号登录服务
 *
 * @author NYJ
 */

public interface IApiWechatMpService {

    /**
     * 验证Token
     * @param msgSignature 签名串，对应URL参数的signature
     * @param timeStamp 时间戳，对应URL参数的timestamp
     * @param nonce 随机串，对应URL参数的nonce
     *
     * @return 是否为安全签名
     * @throws AesException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    boolean verificationToken(String msgSignature, String timeStamp, String nonce, String token);

    /**
     * 获取临时带参二维码
     * @param configure     公众号配置
     * @param sceneStr      登陆码
     * @param expireSeconds 二维码的有效时间，以秒为单位。最大不超过2592000。
     * @return WxMpQrCodeTicket
     */
    WechatQrCode getQrCodeCreateTmpTicket(WechatMpConfigure configure, String sceneStr, Integer expireSeconds);

    /**
     * 获取用户信息
     * @param configure     公众号配置
     * @param openId        用户编号
     * @return WxMpQrCodeTicket
     */
    WxMpUser getUserInfo(WechatMpConfigure configure, String openId);

    /**
     * 事件处理
     * @param xmlData 微信XML数据
     * @return WechatQrCodeLogin
     */
    WechatQrCodeLogin handleMessage(String xmlData);

    /**
     * <pre>
     * 构造第三方使用网站应用授权登录的url.
     * 详情请见: <a href="https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316505&token=&lang=zh_CN">网站应用微信登录开发指南</a>
     * URL格式为：https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     * </pre>
     *
     * @param configure     公众号配置
     * @param redirectUri 用户授权完成后的重定向链接，无需urlencode, 方法内会进行encode
     * @param state       非必填，用于保持请求和回调的状态，授权请求后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验
     * @return url string
     */
    String buildQrConnectUrl(WechatMpConfigure configure,
                             String redirectUri,
                             String state);


    /**
     * 获取用户手机号
     * @param configure     小程序配置
     * @param code          授权码
     * @return WxMpQrCodeTicket
     */
    String getUserPhoneNumber(WechatMaConfigure configure, String code);

}
