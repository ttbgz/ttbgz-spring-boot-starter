package com.ttbgz.huifu.service;

import com.ttbgz.huifu.entity.pay.WxJsApiPay;
import com.ttbgz.huifu.entity.vo.TradePaymentPay;
import jakarta.validation.constraints.NotBlank;

/**
 * 用户支付
 * @author ttbgz
 */
public interface UserPayService {

    /**
     * wx小程序 支付
     * @param transAmt 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     * @param huifuId  渠道与一级代理商的直属商户ID；示例值：6666000123123123
     * @param goodsDesc 商品描述
     * @param openId 微信 openId
     * @return wxJsApiPay
     */
    WxJsApiPay createWxMiniAppPay(@NotBlank String transAmt, @NotBlank String huifuId,@NotBlank String goodsDesc,@NotBlank String openId,String remark);
    /**
     * wx小程序 支付
     * @param transAmt 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     * @param huifuId  渠道与一级代理商的直属商户ID；示例值：6666000123123123
     * @param goodsDesc 商品描述
     * @param openId 微信 openId
     * @param notifyUrl 回调 地址
     * @param tradePaymentJsPay 其他可选参数
     * @return wxJsApiPay
     */
    WxJsApiPay createWxMiniAppPay(@NotBlank String transAmt, @NotBlank String huifuId, @NotBlank String goodsDesc, @NotBlank String openId, String notifyUrl, TradePaymentPay tradePaymentJsPay, String remark);

    /**
     * 创建微信二维码支付
     * @param transAmt 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     * @param huifuId   渠道与一级代理商的直属商户ID；示例值：6666000123123123
     * @param goodsDesc 商品描述
     * @return 二维码url
     */
    String createWxQrCode(@NotBlank String transAmt, @NotBlank String huifuId,@NotBlank String goodsDesc,String remark);
    /**
     * 创建微信二维码支付
     * @param transAmt 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     * @param huifuId   渠道与一级代理商的直属商户ID；示例值：6666000123123123
     * @param goodsDesc 商品描述
     * @param notifyUrl 回调 地址
     * @return 二维码url
     */
    String createWxQrCode(@NotBlank String transAmt, @NotBlank String huifuId,@NotBlank String goodsDesc,String notifyUrl,String remark);
    /**
     * 创建微信二维码支付
     * @param transAmt 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     * @param huifuId   渠道与一级代理商的直属商户ID；示例值：6666000123123123
     * @param goodsDesc 商品描述
     * @param notifyUrl 回调 地址
     * @param tradePaymentJsPay 可选参数
     * @return 二维码url
     */
    String createWxQrCode(@NotBlank String transAmt, @NotBlank String huifuId, @NotBlank String goodsDesc, String notifyUrl, TradePaymentPay tradePaymentJsPay,String remark);

}
