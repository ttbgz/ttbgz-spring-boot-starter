package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 余额支付
 * @author Administrator
 */
@Data
public class TradeAcctpaymentPayVo {
    /**
     * 请求流水号
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 请求日期
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 	出款方商户号
     */
    @JSONField(name = "out_huifu_id")
    private String outHuifuId;
    /**
     * 支付金额
     */
    @JSONField(name = "ord_amt")
    private String ordAmt;
    /**
     * 商品描述
     */
    @JSONField(name = "good_desc")
    private String goodDesc;
    /**
     * 	备注
     */
    @JSONField(name = "remark")
    private String remark;
    /**
     *是否延迟交易 	Y 为延迟，N为不延迟，不传默认N；示例值：Y
     */
    @JSONField(name = "delay_acct_flag")
    private String delayAcctFlag;
    /**
     *  分账对象
     */
    @JSONField(name = "acct_split_bunch")
    private AcctSplitBunch acctSplitBunch;

    /**
     *  安全信息
     */
    @JSONField(name = "risk_check_data")
    private RiskCheckData riskCheckData;

    /**
     * 	出款方账户号
     */
    @JSONField(name = "out_acct_id")
    private String outAcctId;
    /**
     * 	资金类型
     */
    @JSONField(name = "fund_type")
    private String fundType;

    /**
     * 	支付渠道
     */
    @JSONField(name = "acct_channel")
    private String acctChannel;
    /**
     * 	灵活用工标志
     */
    @JSONField(name = "hyc_flag")
    private String hycFlag;
    /**
     * 	灵活用工平台
     */
    @JSONField(name = "lg_platform_type")
    private String lgPlatformType;
    /**
     * 	代发模式
     */
    @JSONField(name = "salary_modle_type")
    private String salaryModleType;
    /**
     * 	落地公司商户号
     */
    @JSONField(name = "bmember_id")
    private String bmemberId;
    /**
     * 	异步通知地址
     */
    @JSONField(name = "notify_url")
    private String notifyUrl;
    /**
     * 	手续费承担方标识
     * 		余额支付手续费承担方标识；商户余额支付扣收规则为接口指定承担方时必填！枚举值： OUT：出款方； IN：分账接受方。 示例值：IN
     */
    @JSONField(name = "trans_fee_take_flag")
    private String transFeeTakeFlag;


    /**
     * 非必填字段
     * @return
     */
    public Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();

        if (this.goodDesc!=null){
            extendInfoMap.put("good_desc", this.goodDesc);
        }
        if (this.remark!=null){
            extendInfoMap.put("remark", this.remark);
        }

        if (this.outAcctId!=null){
            extendInfoMap.put("out_acct_id", this.outAcctId);
        }

        if (this.fundType!=null){
            extendInfoMap.put("fund_type", this.fundType);
        }

        if (this.acctChannel!=null){
            extendInfoMap.put("acct_channel", this.acctChannel);
        }

        if (this.hycFlag!=null){
            extendInfoMap.put("hyc_flag", this.hycFlag);
        }
        if (this.lgPlatformType!=null){
            extendInfoMap.put("lg_platform_type", this.lgPlatformType);
        }
        if (this.salaryModleType!=null){
            extendInfoMap.put("salary_modle_type", this.salaryModleType);
        }

        if (this.bmemberId!=null){
            extendInfoMap.put("bmember_id", this.bmemberId);
        }
        if (this.notifyUrl!=null){
            extendInfoMap.put("notify_url", this.notifyUrl);
        }
        if (this.transFeeTakeFlag!=null){
            extendInfoMap.put("trans_fee_take_flag", this.transFeeTakeFlag);
        }
//        //对象处理
//        if (this.acctSplitBunch!=null){
//            String string = JSON.toJSONString(this.acctSplitBunch, JSONWriter.Feature.IgnoreNoneSerializable);
//            extendInfoMap.put("acct_split_bunch", JSON.parseObject(string, JSONObject.class));
//        }
//
//        if (this.riskCheckData!=null){
//            String string = JSON.toJSONString(this.riskCheckData, JSONWriter.Feature.IgnoreNoneSerializable);
//            extendInfoMap.put("risk_check_data", JSON.parseObject(string, JSONObject.class));
//        }
        return extendInfoMap;
    }
}
