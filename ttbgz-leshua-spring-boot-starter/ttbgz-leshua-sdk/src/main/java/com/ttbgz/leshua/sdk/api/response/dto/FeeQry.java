package com.ttbgz.leshua.sdk.api.response.dto;

import java.io.Serializable;

public class FeeQry implements Serializable {

    private static final long serialVersionUID = 2390821965605196650L;

    private WeixinFee weixinFee;//微信扫码费率
    private AlipayFee alipayFee;//支付宝扫码费率
    private CardFee cardFee;//刷卡费率
    private UnionScanFee unionScanFee;//银联扫码费率大于1000元
    private UnionScanFee2 unionScanFee2;//银联扫码费率小于等于1000元

    public WeixinFee getWeiXin() {
        return weixinFee;
    }

    public void setWeiXin(WeixinFee weixinFee) {
        this.weixinFee = weixinFee;
    }

    public AlipayFee getAlipay() {
        return alipayFee;
    }

    public void setAlipay(AlipayFee alipay) {
        this.alipayFee = alipay;
    }

    public CardFee getCard() {
        return cardFee;
    }

    public void setCard(CardFee card) {
        this.cardFee = card;
    }

    public UnionScanFee getUnionScan() {
        return unionScanFee;
    }

    public void setUnionScan(UnionScanFee unionScanFee) {
        this.unionScanFee = unionScanFee;
    }

    public UnionScanFee2 getUnionScan2() {
        return unionScanFee2;
    }

    public void setUnionScan2(UnionScanFee2 unionScan2) {
        this.unionScanFee2 = unionScan2;
    }

    @Override
    public String toString() {
        return "FeeQry{" +
                "weixinFee:" + weixinFee +
                ", alipayFee:" + alipayFee +
                ", cardFee:" + cardFee +
                ", unionScanFee:" + unionScanFee +
                ", unionScanFee2:" + unionScanFee2 +
                '}';
    }
}

