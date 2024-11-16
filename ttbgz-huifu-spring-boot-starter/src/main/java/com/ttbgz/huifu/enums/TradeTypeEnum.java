package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 * @author ttbgz
 */

@Getter
public enum TradeTypeEnum {
    //T_JSAPI: 微信公众号,T_MINIAPP: 微信小程序,A_JSAPI: 支付宝JS,A_NATIVE: 支付宝正扫,U_NATIVE: 银联正扫,U_JSAPI: 银联JS,D_NATIVE: 数字人民币正扫,T_H5：微信直连H5支付,T_APP：微信APP支付,T_NATIVE：微信正扫
    T_JSAPI("T_JSAPI","微信公众号支付"),
    T_MINIAPP("T_MINIAPP","微信小程序支付"),
    A_JSAPI("A_JSAPI","支付宝JS"),
    A_NATIVE("A_NATIVE","支付宝正扫"),
    U_NATIVE("U_NATIVE","银联正扫"),
    U_JSAPI("U_JSAPI","银联 JS"),
    D_NATIVE("D_NATIVE","数字人民币正扫"),
    T_H5("T_H5","微信直连H5支付"),
    T_APP("T_APP","微信APP支付"),
    T_NATIVE("T_NATIVE","微信正扫");

    private final String code;

    private final String desc;
    TradeTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
