package com.ttbgz.huifu.utils.entity;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 汇付交易记录对象 hf_pay_record
 *  此类适合remark 作为自己系统id的订单号的情况
 * @author ruoyi
 * @date 2024-10-29
 */
@Getter
@Setter
public class HfPayRecordPojo implements Serializable {

    /** 请求时间 */
    @JSONField(name = "req_date")
    private String reqDate;

    /** 请求流水号 */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;

    /** 全局流水号 */
    @JSONField(name = "hf_seq_id")
    private String hfSeqId;

    /** 交易类型 */
    @JSONField(name = "trade_type")
    private String tradeType;

    /** 交易状态 P:处理中、S:成功、F:失败；交易状态以此字段为准 */
    @JSONField(name = "trans_stat")
    private String transStat;

    /** 交易金额 */
    @JSONField(name = "trans_amt")
    private String transAmt;

    /** 消费者实付金额 */
    @JSONField(name = "pay_amt")
    private String payAmt;

    /** 结算金额(元) */
    @JSONField(name = "settlement_amt")
    private String settlementAmt;

    /** 支付完成时间 */
    @JSONField(name = "end_time")
    private String endTime;

    /** 入账时间 */
    @JSONField(name = "acct_date")
    private String acctDate;

    /** 手续费金额 */
    @JSONField(name = "fee_amount")
    private String feeAmount;
    /** 通知类型 1：通道通知，2：账务通知；示例值：1 */
    @JSONField(name = "notify_type")
    private String notifyType;

    /** 订单id */
    @JSONField(name = "remark")
    private Long orderId;


}
