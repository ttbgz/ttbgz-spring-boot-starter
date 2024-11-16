package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import com.ttbgz.huifu.entity.vo.AcctSplitBunch;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradeAcctpaymentPayResp extends HuiFuResp implements Serializable {
    /**
     * 请求流水号
     *
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 请求日期
     *
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 商户号
     *
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 出款商户号
     *
     */
    @JSONField(name = "out_huifu_id")
    private String outHuifuId;
    /**
     * ord_amt	支付金额
     *
     */
    @JSONField(name = "acct_split_bunch")
    private AcctSplitBunch acctSplitBunch;
    /**
     * 分账对象
     *
     */
    @JSONField(name = "hf_seq_id")
    private String hfSeqId;
    /**
     * 全局流水号
     *
     */
    @JSONField(name = "good_desc")
    private String goodDesc;
    /**
     * 商品描述
     *
     */
    @JSONField(name = "trans_stat")
    private String transStat;
    /**
     * 交易状态
     *
     */
    @JSONField(name = "trans_finish_time")
    private String transFinishTime;
    /**
     * 交易完成时间
     *
     */
    @JSONField(name = "remark")
    private String remark;
    /**
     * 备注
     *
     */
    @JSONField(name = "out_acct_id")
    private String outAcctId;
    /**
     * 出款方账户号
     *
     */
    @JSONField(name = "fund_type")
    private String fundType;
    /**
     * 资金类型
     *
     */
    @JSONField(name = "acct_channel")
    private String acctChannel;
    /**
     * 支付渠道
     *
     */
    @JSONField(name = "hyc_flag")
    private String hycFlag;
    /**
     * 灵活用工标志
     *
     */
    @JSONField(name = "lg_platform_type")
    private String lgPlatformType;
    /**
     * 灵活用工平台
     *
     */
    @JSONField(name = "salary_modle_type")
    private String salaryModleType;
    /**
     * 代发模式
     *
     */
    @JSONField(name = "bmember_id")
    private String bmemberId;
    /**
     * 落地公司商户号
     *
     */
    @JSONField(name = "hyc_attach_id")
    private String hycAttachId;
//    /**
//     * 灵活用工代发批次号
//     *  自己实现
//     */
//    @JSONField(name = "ljh_response")
//    private String ljhResponse;
    /**
     * 乐接活返回参数集合
     *
     */
    @JSONField(name = "trans_fee_take_flag")
    private String transFeeTakeFlag;
    /**
     * 手续费承担方标识
     *
     */
    @JSONField(name = "unconfirm_amt")
    private String unconfirmAmt;
    /**
     * 待确认总金额
     *
     */
    @JSONField(name = "confirmed_amt")
    private String confirmedAmt;



}
