package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 取现配置列表
 * @author ttbgz
 */
@Data
public class CashConfig implements Serializable {
    /**
     *  业务类型
     *  String  2 N T1:下一工作日到银行账户；
     *  D1：下一自然日到银行账户；
     *  D0：当日到银行账户；默认D0；
     *  DM：当日到账；到账资金不包括当天的交易资金；
     *  示例值：T1
     */
    @JSONField(name = "cash_type",deserialize = false)
    private String  cashType;
    /**
     *  提现手续费（固定/元）
     *  string  6 C fix_amt与fee_rate至少填写一项， 需保留小数点后两位，不收费请填写0.00；示例值：1.00
     *  注：当cash_type=D1时为节假日取现手续费
     */
    @JSONField(name = "fix_amt")
    private String  fixAmt;
    /**
     *  提现手续费率（%）
     *  string  6 C fix_amt与fee_rate至少填写一项，需保留小数点后两位，取值范围[0.00,100.00]，不收费请填写0.00；示例值：0.05
     *  注：1、如果fix_amt与fee_rate都填写了则手续费=fix_amt+支付金额*fee_rate
     *  2、当cash_type=D1时为节假日取现手续费
     */
    @JSONField(name = "fee_rate")
    private String  feeRate;
    /**
     *  D1工作日取现手续费固定金额
     *  String  6 C 单位元，需保留小数点后两位。不收费请填写0.00；示例值：1.00
     *  D1取现配置时选填，其他取现配置无效；cash_type取现类型为D1时，遇工作日按此费率结算，若未配置则默认按照节假日手续费计算
     */
    @JSONField(name = "weekday_fix_amt")
    private String  weekdayFixAmt;
    /**
     *   D1工作日取现手续费率
     *   String  6 C 单位%，需保留小数点后两位。取值范围[0.00，100.00]，不收费请填写0.00；示例值：0.05
     *  D1取现配置时选填，其他取现配置无效；cash_type取现类型为D1时，遇工作日按此费率结算 ，若未配置则默认按照节假日手续费计算
     */
    @JSONField(name = "weekday_fee_rate")
    private String  weekdayFeeRate;
    /**
     *   是否交易手续费外扣
     *   String  1 N 1:外扣 2:内扣（默认2内扣）；示例值：1
     *     1:外扣 2:内扣（默认2内扣）；示例值：1
     */
    @JSONField(name = "out_fee_flag")
    private String  outFeeFlag;
    /**
     *   手续费承担方
     *    String  18  N 手续费外扣时必需指定手续费承担方ID；示例值：6666000123123123
     *
     */
    @JSONField(name = "out_fee_huifu_id")
    private String  outFeeHuifuId;
    /**
     *  交易手续费外扣的账户类型
     *  String  2 N 01-基本户，05-充值户；不填默认01； 示例值：01
     *
     */
    @JSONField(name = "out_fee_acct_type")
    private String  outFeeAcctType;
    /**
     *  是否优先到账
     *  String  1 N Y：是 ，N：否。不填，默认值为否。仅在取现类型配置为D1 和 T1 时生效。示例值：Y
     *
     */
    @JSONField(name = "is_priority_receipt")
    private String  isPriorityReceipt;

    //---- ----------------  返回值参数
    /**
     * 是否开通取现手续费外扣
     * N	1	1:外扣 2:内扣；示例值：1
     */
    @JSONField(name = "out_cash_flag")
    private String  outCashFlag;
    /**
     * 手续费承担方
     * N	18	手续费外扣时必需指定手续费承担方ID；示例值：6666000123120000
     */
    @JSONField(name = "out_cash_huifuid")
    private String  outCashHuifuid;
    /**
     * 取现手续费外扣子账户类型
     * N	2	01:基本户 05:充值户；示例值：01
     */
    @JSONField(name = "out_cash_acct_type")
    private String  outCashAcctType;




}
