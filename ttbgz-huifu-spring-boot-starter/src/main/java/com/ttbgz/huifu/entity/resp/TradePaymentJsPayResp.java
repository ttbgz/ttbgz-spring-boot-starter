package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 支付响应
 *
 * @author ttbgz
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TradePaymentJsPayResp extends HuiFuResp implements Serializable {
    /**
     * 业务响应码
     * 8 Y 业务返回码
     */
    @JSONField(name = "resp_code")
    private String respCode;
    /**
     * 业务响应信息
     * 256 Y 业务返回描述
     */
    @JSONField(name = "resp_desc")
    private String respDesc;
    /**
     * 请求时间
     * 8 Y 交易时传入，原样返回；示例值：20220905
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 请求流水号
     * 128 Y 交易时传入，原样返回；示例值：rQ2021121311173944134649875651
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 全局流水号
     * 128 N 示例值：00470topo1A221019132207P068ac1362af00000
     */
    @JSONField(name = "hf_seq_id")
    private String hfSeqId;
    /**
     * 交易类型
     * 16  N T_JSAPI: 微信公众号支付
     */
    @JSONField(name = "trade_type")
    private String tradeType;
    /**
     * 交易金额
     * 14  N 单位元， 示例值：1.00
     */
    @JSONField(name = "trans_amt")
    private String transAmt;
    /**
     * 交易状态
     * 1 N P:处理中、S:成功、F:失败；交易状态以此字段为准。示例值：S
     */
    @JSONField(name = "trans_stat")
    private String transStat;
    /**
     * 商户号
     * 32  Y 示例值：6666000123123123
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 通道返回码
     * 32  N 请勿根据此字段判断交易状态，此字段建议在交易失败时配合bank_message使用。示例值：00
     */
    @JSONField(name = "bank_code")
    private String bankCode;
    /**
     * 通道返回描述
     * 200 N 示例值：成功[0000000]
     */
    @JSONField(name = "bank_message")
    private String bankMessage;
    /**
     * 延时标记
     * 1 N Y: 延迟 N: 实时（默认）；示例值：Y
     */
    @JSONField(name = "delay_acct_flag")
    private String delayAcctFlag;
    /**
     * js支付信息
     * 1024  N JSAPI支付返回信息；
     */
    @JSONField(name = "pay_info")
    private String payInfo;
    /**
     * 二维码链接
     * 1024  N NATIVE支付返回二维码链接；
     */
    @JSONField(name = "qr_code")
    private String qrCode;

    /**
     * 支付宝返回的响应报文
     * N json格式
     */
    @JSONField(name = "alipay_response")
    private AlipayResponse alipayResponse;
    /**
     * 微信返回的响应报文
     * N json格式
     */
    @JSONField(name = "wx_response")
    private WxResponse wxResponse;
    /**
     * 银联返回的响应报文
     * N json格式
     */
    @JSONField(name = "unionpay_response")
    private UnionpayResponse unionpayResponse;
    /**
     * 备注
     * 255 N 原样返回；示例值：备注
     */
    @JSONField(name = "remark")
    private String remark;
    /**
     * 账户号
     * 9 N 商户账户号；示例值：F00598600
     */
    @JSONField(name = "acct_id")
    private String acctId;
    /**
     * 终端类型
     * 2 N 01-智能POS
     */
    @JSONField(name = "device_type")
    private String deviceType;
    /**
     * 用户账单上的商户订单号
     * 64  N 参见用户账单说明；示例值：03232109190255105603561
     */
    @JSONField(name = "party_order_id")
    private String partyOrderId;
    /**
     * ATU真实商户号
     * 32  N 微信、支付宝、银联真实商户号；示例值：411111141
     */
    @JSONField(name = "atu_sub_mer_id")
    private String atuSubMerId;
    /**
     * 待确认金额
     * 14  N 待确认金额；单位元。示例值：1.00
     */
    @JSONField(name = "unconfirm_amt")
    private String unconfirmAmt;
}
