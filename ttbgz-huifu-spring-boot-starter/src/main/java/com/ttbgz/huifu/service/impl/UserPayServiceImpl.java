package com.ttbgz.huifu.service.impl;

import com.alibaba.fastjson2.JSON;
import com.huifu.bspay.sdk.opps.client.BasePayClient;
import com.huifu.bspay.sdk.opps.core.request.V2TradePaymentJspayRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.ttbgz.huifu.entity.pay.WxJsApiPay;
import com.ttbgz.huifu.entity.resp.TradePaymentJsPayResp;
import com.ttbgz.huifu.entity.vo.TradePaymentPay;
import com.ttbgz.huifu.entity.vo.WxData;
import com.ttbgz.huifu.enums.TradeTypeEnum;
import com.ttbgz.huifu.service.UserPayService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
public class UserPayServiceImpl implements UserPayService {
    /**
     * 实际支付执行
     */
    private TradePaymentJsPayResp aggregatePaymentsExecute(TradePaymentPay tradePaymentJsPay){

        // 2.组装请求参数
        V2TradePaymentJspayRequest request = new V2TradePaymentJspayRequest();
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 商户号
        request.setHuifuId(tradePaymentJsPay.getHuifuId());
        // 交易类型
        request.setTradeType(tradePaymentJsPay.getTradeType().getCode());
        // 交易金额
        request.setTransAmt(tradePaymentJsPay.getTransAmt());
        // 商品描述
        request.setGoodsDesc(tradePaymentJsPay.getGoodsDesc());

        // 设置非必填字段
        Map<String, Object> extendInfoMap = tradePaymentJsPay.getExtendInfos();
        request.setExtendInfo(extendInfoMap);
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            return JSON.to(TradePaymentJsPayResp.class,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WxJsApiPay createWxMiniAppPay(String transAmt, String huifuId, String goodsDesc, String openId, String remark) {
        return this.createWxMiniAppPay(transAmt,huifuId,goodsDesc,openId,null,null,null);
    }

    @Override
    public WxJsApiPay createWxMiniAppPay(String transAmt, String huifuId, String goodsDesc, String openId, String notifyUrl, TradePaymentPay tradePaymentJsPay,String remark) {
        if (tradePaymentJsPay==null){
            tradePaymentJsPay=new TradePaymentPay();
        }
        tradePaymentJsPay.setTradeType(TradeTypeEnum.T_MINIAPP);

        tradePaymentJsPay.setTransAmt(transAmt);
        tradePaymentJsPay.setHuifuId(huifuId);
        tradePaymentJsPay.setGoodsDesc(goodsDesc);
        //openId 处理
        if (tradePaymentJsPay.getWxData()==null){
            tradePaymentJsPay.setWxData(new WxData(){{setSubOpenid(openId);}});
        }else{
            tradePaymentJsPay.getWxData().setSubOpenid(openId);
        }
        //判断是否有备注
        if (remark!=null){
            tradePaymentJsPay.setRemark(remark);
        }
        //notifyUrl 处理
        if (notifyUrl!=null){
            tradePaymentJsPay.setNotifyUrl(notifyUrl);
        }
        TradePaymentJsPayResp resp = aggregatePaymentsExecute(tradePaymentJsPay);
        return JSON.parseObject(resp.getPayInfo(),WxJsApiPay.class);
    }

    @Override
    public String createWxQrCode(String transAmt, String huifuId, String goodsDesc,String remark) {
        return this.createWxQrCode(transAmt,huifuId,goodsDesc,null,null);
    }

    @Override
    public String createWxQrCode(String transAmt, String huifuId, String goodsDesc, String notifyUrl,String remark) {
        return this.createWxQrCode(transAmt,huifuId,goodsDesc,notifyUrl,null,null);
    }

    @Override
    public String createWxQrCode(String transAmt, String huifuId, String goodsDesc, String notifyUrl, TradePaymentPay tradePaymentJsPay,String remark) {
        if (tradePaymentJsPay==null){
            tradePaymentJsPay=new TradePaymentPay();
        }
        tradePaymentJsPay.setTradeType(TradeTypeEnum.T_NATIVE);

        tradePaymentJsPay.setTransAmt(transAmt);
        tradePaymentJsPay.setHuifuId(huifuId);
        tradePaymentJsPay.setGoodsDesc(goodsDesc);

        //判断是否有备注
        if (remark!=null){
            tradePaymentJsPay.setRemark(remark);
        }
        //notifyUrl 处理
        if (notifyUrl!=null){
            tradePaymentJsPay.setNotifyUrl(notifyUrl);
        }
        TradePaymentJsPayResp resp = aggregatePaymentsExecute(tradePaymentJsPay);
        return resp.getQrCode();
    }


}
