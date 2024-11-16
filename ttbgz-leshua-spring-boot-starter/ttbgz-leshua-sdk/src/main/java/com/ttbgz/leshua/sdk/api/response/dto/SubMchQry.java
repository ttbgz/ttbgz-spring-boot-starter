package com.ttbgz.leshua.sdk.api.response.dto;

import java.io.Serializable;
import java.util.List;

public class SubMchQry implements Serializable {
    private String merchantId;
    private List<WeixinSubMch> weixinSubMches;
    private List<AlipaySubMch> alipaySubMches;
    private List<UnionPayQRASubMch> unionPayQRASubMches;
    private List<UnionScanSubMch> unionScanSubMches;
    private List<CupsSubMch> cupsSubMches;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public List<WeixinSubMch> getWechat() {
        return weixinSubMches;
    }

    public void setWechat(List<WeixinSubMch> weixinSubMches) {
        this.weixinSubMches = weixinSubMches;
    }

    public List<AlipaySubMch> getAlipay() {
        return alipaySubMches;
    }

    public void setAlipay(List<AlipaySubMch> alipaySubMches) {
        this.alipaySubMches = alipaySubMches;
    }

    public List<UnionPayQRASubMch> getUnionpayQRA() {
        return unionPayQRASubMches;
    }

    public void setUnionpayQRA(List<UnionPayQRASubMch> unionPayQRASubMches) {
        this.unionPayQRASubMches = unionPayQRASubMches;
    }

    public List<UnionScanSubMch> getUnionscan() {
        return unionScanSubMches;
    }

    public void setUnionsca(List<UnionScanSubMch> unionScanSubMches) {
        this.unionScanSubMches = unionScanSubMches;
    }

    public List<CupsSubMch> getCups() {
        return cupsSubMches;
    }

    public void setCups(List<CupsSubMch> cupsSubMches) {
        this.cupsSubMches = cupsSubMches;
    }

    @Override
    public String toString() {
        return "{" +
                "merchantId='" + merchantId + '\'' +
                ", weixinSubMches:" + weixinSubMches +
                ", alipaySubMches:" + alipaySubMches +
                ", unionPayQRASubMches:" + unionPayQRASubMches +
                ", unionScanSubMches:" + unionScanSubMches +
                ", cupsSubMches:" + cupsSubMches +
                '}';
    }
}
