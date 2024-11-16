package com.ttbgz.wechat.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.ttbgz.wechat.model.WechatMaConfigure;
import com.ttbgz.wechat.model.WechatMpConfigure;
import com.ttbgz.wechat.model.WechatOpenConfigure;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 微信配置
 *
 * @author NYJ
 * @date 2023/08/11
 */
@Component
public class Configuration {

    protected final Logger logger = LoggerFactory.getLogger(Configuration.class);

    /**
     * 配置微信公众号资料
     *
     * @return WxMaService
     */
    private WxMpConfigStorage getWxMaConfigStorage(WechatMpConfigure configure) {
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        // 公众号appId
        configStorage.setAppId(configure.getAppId());
        // 公众号appSecret
        configStorage.setSecret(configure.getSecret());
        // 公众号Token
        configStorage.setToken(configure.getToken());
        // 公众号EncodingAESKey
        configStorage.setAesKey(configure.getEncodingAesKey());
        return configStorage;
    }

    /**
     * 配置微信开放平台资料
     *
     * @return WxMaService
     */
    private WxOpenConfigStorage getWxOpenConfigStorage(WechatOpenConfigure configure) {

        WxOpenConfigStorage config = new WxOpenInMemoryConfigStorage();
        // 公众号appId
        config.setWxOpenInfo(configure.getAppId(), configure.getSecret(), configure.getToken(), configure.getAesKey());
        return config;
    }

    /**
     * 获取微信公众号服务
     *
     * @return WxMaService
     */
    public WxMpService getWxMpService(WechatMpConfigure configure) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(getWxMaConfigStorage(configure));
        return wxMpService;
    }

    /**
     * 获取二维码相关服务
     *
     * @return WxMaService
     */
    public WxMpQrcodeService getWxMpQrcodeService(WechatMpConfigure configure) {
        return getWxMpService(configure).getQrcodeService();
    }

    /**
     * 获取二维码相关服务
     *
     * @return WxMaService
     */
    public WxMpUserService getWxMpUserService(WechatMpConfigure configure) {
        return getWxMpService(configure).getUserService();
    }

    /**
     * 获取微信开放平台服务
     *
     * @return WxMaService
     */
    public WxOpenService getWxOpenService(WechatOpenConfigure configure) {
        WxOpenService openService = new WxOpenServiceImpl();
        openService.setWxOpenConfigStorage(getWxOpenConfigStorage(configure));
        return openService;
    }


    /**
     * 微信小程序资料
     *
     * @return WxMaService
     */
    public WxMaService getWxMaService(WechatMaConfigure configure) {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        // 小程序appId
        config.setAppid(configure.getAppId());
        // 小程序appSecret
        config.setSecret(configure.getSecret());
        // 小程序消息格式，JSON
        config.setMsgDataFormat("JSON");

        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(config);
        return wxMaService;
    }
}
