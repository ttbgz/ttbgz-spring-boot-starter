package com.ttbgz.wechat.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.util.WxMaConfigHolder;
import com.ttbgz.wechat.config.Configuration;
import com.ttbgz.wechat.exception.AesException;
import com.ttbgz.wechat.model.WechatMaConfigure;
import com.ttbgz.wechat.model.WechatMpConfigure;
import com.ttbgz.wechat.model.WechatQrCode;
import com.ttbgz.wechat.model.WechatQrCodeLogin;
import com.ttbgz.wechat.service.IApiWechatMpService;
import com.ttbgz.wechat.utils.BeanUtils;
import com.ttbgz.wechat.utils.Sha1Utils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 微信公众号服务
 * 
 * @author NYJ
 */
@Service
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ApiWechatMpServiceImpl implements IApiWechatMpService {

    private static final Logger log = LoggerFactory.getLogger(ApiWechatMpServiceImpl.class);

    @Autowired
    private final Configuration configuration;

    /**
     * 验证Token
     * @param msgSignature 签名串，对应URL参数的signature
     * @param timeStamp 时间戳，对应URL参数的timestamp
     * @param nonce 随机串，对应URL参数的nonce
     *
     * @return 是否为安全签名
     * @throws AesException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    @Override
    public boolean verificationToken(String msgSignature, String timeStamp, String nonce, String token) {
        // 这里的 WXPublicConstants.TOKEN 填写你自己设置的Token就可以了
        try {
            String signature = Sha1Utils.getSha1(token, timeStamp, nonce);
            if (!signature.equals(msgSignature)) {
                throw new RuntimeException("签名验证错误");
            }
        }catch (Exception e){
            throw new RuntimeException("签名验证错误: " + e.getMessage());
        }

        return true;
    }


    /**
     * 获取临时带参二维码
     * @param configure     公众号配置
     * @param sceneStr      登陆码
     * @param expireSeconds 二维码的有效时间，以秒为单位。最大不超过2592000。
     * @return WxMpQrCodeTicket
     */
    @Override
    public WechatQrCode getQrCodeCreateTmpTicket(WechatMpConfigure configure, String sceneStr, Integer expireSeconds) {

        WxMpQrcodeService qrcodeService = configuration.getWxMpQrcodeService(configure);
        WechatQrCode qrCode = new WechatQrCode();
        try {
            WxMpQrCodeTicket ticket = qrcodeService.qrCodeCreateTmpTicket(sceneStr, expireSeconds);
            if (ticket != null){
                BeanUtils.copyBeanProp(qrCode,ticket);
                qrCode.setScene(sceneStr);
                qrCode.setExpireSeconds(expireSeconds);
            }
        }catch (Exception e){
            throw new RuntimeException("获取二维码失败");
        }
        return qrCode;
    }


    /**
     * 获取用户信息
     * @param configure     公众号配置
     * @param openId        用户编号
     * @return WxMpQrCodeTicket
     */
    @Override
    public WxMpUser getUserInfo(WechatMpConfigure configure, String openId) {

        WxMpUserService userService = configuration.getWxMpUserService(configure);
        try {
            return userService.userInfo(openId);
        }catch (Exception e){
            throw new RuntimeException("获取用户信息失败");
        }
    }

    /**
     * 事件处理
     * @param xmlData 微信XML数据
     * @return WechatQrCodeLogin
     */
    @Override
    public WechatQrCodeLogin handleMessage(String xmlData) {

        log.info("开始事件处理：{}", xmlData);
        Map<String, String> mapData = convertToMap(xmlData);
        //发送方帐号（open_id）
        String fromUserName = mapData.get("FromUserName");
        //消息类型 event
        String msgType = mapData.get("MsgType");
        //场景 事件KEY值，qrscene_为前缀，后面为二维码的参数值
        String eventKey = mapData.get("EventKey");
        String value = "";
        boolean isSuccess = false;
        WechatQrCodeLogin login = new WechatQrCodeLogin();
        login.setOpenId(fromUserName);
        // 事件消息
        if ("event".equals(msgType)) {
            // 区分事件推送
            String event = mapData.get("Event");
            log.info("****区分事件推送****{}", event);
            // 订阅事件 或 未关注扫描二维码事件
            if ("subscribe".equals(event)) {
                isSuccess = true;
                value = eventKey;
                // 已关注扫描二维码事件
            } else if ("SCAN".equals(event)) {
                isSuccess = true;
                value =  eventKey;
                //取关事件
            }else if ("unsubscribe".equals(event)){
                // todo 取关事件
            } else if ("LOCATION".equals(event)) {
                // todo 处理上报地理位置事件
            } else if ("CLICK".equals(event)) {
                // todo 处理点击菜单拉取消息时的事件推送事件
            } else if ("VIEW".equals(event)) {
                // todo 处理点击菜单跳转链接时的事件推送
            }
        }
        login.setScene(value);
        if (isSuccess){
            return login;
        }
        return null;
    }

    /**
     * xml转map
     * @param xml
     * @return
     */
    private static Map<String,String> convertToMap(String xml){
        Map<String, String> map = new LinkedHashMap<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is.getByteStream());

            Element root = document.getDocumentElement();
            if(root != null){
                NodeList childNodes = root.getChildNodes();
                if(childNodes.getLength()>0){
                    for(int i = 0;i < childNodes.getLength();i++){
                        Node node = childNodes.item(i);
                        if( node != null && node.getNodeType() == Node.ELEMENT_NODE){
                            map.put(node.getNodeName(), node.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("xml转map失败:" + e.getMessage());
        }
        return map;
    }


    @Override
    public String buildQrConnectUrl(WechatMpConfigure configure,
                                    String redirectUri,
                                    String state) {
        String qrConnectUrl = "";
        WxMpService mpService = configuration.getWxMpService(configure);
        try {
            qrConnectUrl = mpService.buildQrConnectUrl(redirectUri,
                    WxConsts.QrConnectScope.SNSAPI_LOGIN, state);
        }catch (Exception e){
            throw new RuntimeException("获取用户信息失败");
        }

        return qrConnectUrl;
    }

    @Override
    public String getUserPhoneNumber(WechatMaConfigure configure, String code) {
        WxMaService maService = configuration.getWxMaService(configure);
        WxMaPhoneNumberInfo phoneNoInfo = null;
        try {
            phoneNoInfo = maService.getUserService().getPhoneNoInfo(code);
        } catch (WxErrorException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            //清理ThreadLocal
            WxMaConfigHolder.remove();
        }

        if (phoneNoInfo != null) {
            String phoneNumber = phoneNoInfo.getPhoneNumber();
            return phoneNumber;
        }
        return "";
    }
}