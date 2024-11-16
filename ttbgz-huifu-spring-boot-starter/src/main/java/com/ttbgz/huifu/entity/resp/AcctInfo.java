package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 账户信息
 *
 * @author ttbgz
 */
@Data
public class AcctInfo {
    /**
     * 商户号
     *
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 账户号
     *商户账户的账户号
     */
    @JSONField(name = "acct_id")
    private String acctId;
    /**
     * 账户类型
     * 01:基本户 02:现金户 03：延时户 04:钱包户 05:充值户 09营销户；
     */
    @JSONField(name = "acct_type")
    private String acctType;
    /**
     * 账户余额
     *
     */
    @JSONField(name = "balance_amt")
    private String balanceAmt;
    /**
     * 可用余额
     * 账户可用余额，保留2位小数；
     */
    @JSONField(name = "avl_bal")
    private String avlBal;
    /**
     * 冻结余额
     * 账户冻结余额，保留2位小数；
     */
    @JSONField(name = "frz_bal")
    private String frzBal;
    /**
     * 昨日日终余额
     * 	昨日日终余额，保留2位小数
     */
    @JSONField(name = "last_avl_bal")
    private String lastAvlBal;
    /**
     * 状态
     * N：“正常”; C：“关闭”; F：“冻结”; D：“销户”；示例值：N
     */
    @JSONField(name = "acct_stat")
    private String acctStat;
    /**
     * 管控金额
     * 该金额包含在冻结金额中
     */
    @JSONField(name = "control_bal")
    private String controlBal;
}
