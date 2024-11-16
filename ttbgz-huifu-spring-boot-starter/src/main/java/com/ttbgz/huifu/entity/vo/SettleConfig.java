package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 结算信息配置
 * @author ttbgz
 */
@Data
public class SettleConfig implements Serializable {
    /**
     *  结算周期
     *  结算周期  String  2 Y T1：下个工作日到账；D1：下个自然日到账；示例值：T1
     */
    @NotBlank(message = "结算周期不能为空")
    @JSONField(name = "settle_cycle")
    private String  settleCycle;
    /**
     *  起结金额
     *  起结金额  String  14  N 超过该金额后才会结算，单位为元，精确到小数点后两位。取值范围[0.01,99999999999.99]；示例值：100.00
     */
    @JSONField(name = "min_amt")
    private String  minAmt;
    /**
     *  留存金额
     *  留存金额  String  14  N 小于等于该金额不会结算，单位为元，精确到小数点后两位。取值范围[0.01,99999999999.99]；示例值：100.00
     */
    @JSONField(name = "remained_amt")
    private String  remainedAmt;
    /**
     *  结算摘要
     *  结算摘要  String  128 N 如果需要自定义结算打款备注，请使用此字段传入，默认为空；支持配置格式化摘要内容，参见结算配置示例说明；示例值：业务收款
     */
    @JSONField(name = "settle_abstract")
    private String  settleAbstract;
    /**
     *  手续费外扣标记
     *  手续费外扣标记 String  1 N 1：外扣；2：内扣(为空时默认值)；示例值：1
     */
    @JSONField(name = "out_settle_flag")
    private String  outSettleFlag;
    /**
     *  结算手续费外扣时的汇付ID
     *  结算手续费外扣时的汇付ID String  18  C 外扣手续费承担方的汇付ID。外扣时必填；示例值：6666000123123123
     */
    @JSONField(name = "out_settle_huifuid")
    private String  outSettleHuifuid;
    /**
     *  结算手续费外扣时的账户类型
     *   结算手续费外扣时的账户类型 String  2 C 外扣手续费账户类型； 01：基本户（为空时默认值）， 05：充值户；外扣时必填；示例值：01
     */
    @JSONField(name = "out_settle_acct_type")
    private String  outSettleAcctType;
    /**
     *  结算方式
     *   结算方式  String  2 N P0：批次结算（为空时默认值）， P1：定时结算(建议选P0和P2)，P2:批次定时结算；示例值：P0
     */
    @JSONField(name = "settle_pattern")
    private String  settlePattern;
    /**
     *  结算批次号
     *  结算批次号 String  32  C settle_pattern为P0时必填；参见结算批次说明
     */
    @JSONField(name = "settle_batch_no")
    private String  settleBatchNo;
    /**
     *  是否优先到账
     *  是否优先到账  String  1 C settle_pattern为P0时选填， Y：是 N：否（为空默认取值）；示例值：Y
     */
    @JSONField(name = "is_priority_receipt")
    private String  isPriorityReceipt;
    /**
     *  自定义结算处理时间
     *  自定义结算处理时间 String  6 C settle_pattern为P1/P2时必填，注意：00:00到00:30不能指定；格式：HHmmss；示例值：103000
     */
    @JSONField(name = "settle_time")
    private String  settleTime;
    /**
     *  节假日结算手续费率
     *  节假日结算手续费率 String  6 C settle_cycle为D1时必填。单位%，需保留小数点后两位。取值范围[0.00，100.00]，不收费请填写0.00；settle_cycle=T1时，不生效 ；settle_cycle为D1时，遇节假日按此费率结算 ；示例值：0.05
     */
    @JSONField(name = "fixed_ratio")
    private String  fixedRatio;
    /**
     *  工作日结算手续费率
     * 工作日结算手续费率 String  6 N 单位%，需保留小数点后两位。取值范围[0.00，100.00]，不填默认为0.00；示例值：0.05
     */
    @JSONField(name = "workday_fixed_ratio")
    private String  workdayFixedRatio;
    /**
     *  工作日结算手续费固定金额
     *  工作日结算手续费固定金额  String  15  N 单位元，需保留小数点后两位。不填默认为0.00；示例值：1.00
     */
    @JSONField(name = "workday_constant_amt")
    private String  workdayConstantAmt;
}
