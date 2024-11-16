package com.ttbgz.leshua.sdk.api.response.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Mercy
 * @date 2018/6/12
 */
public class RemitNotifyMsgDto {

    /**
     * 一代编号
     */
    private String topAgentId;

    /**
     * 商户编号
     */
    private String merchantId;

    /**
     * 打款回到url
     */
    private String remitNotifyUrl;

    /**
     * 打款单号
     */
    private String billId;

    /**
     * 结算类型： T0/T1
     */
    private String settleType;

    /**
     * 打款日期
     */
    private String remitDate;

    /**
     * 结算日期
     */
    private String settleDate;

    /**
     * 备注： 暂时用于T1退票时关联原订单号
     */
    private String remark;

    /**
     * 应付金额(分)
     */
    private Long planSettleAmount;

    /**
     * 止付金额(分)
     */
    private Long suspendSettleAmount;

    /**
     * 实付金额(分)
     */
    private Long realSettleAmount;

    /**
     * 打款状态
     */
    private String state;

    /**
     * 失败原因
     */
    private String failReason;

    private String amount;

    private String bankCard;

    private String bankName;

    private String bankNo;

    private String date;

    private String updateTime;

    private String bankHolder;

    private String bankAccount;

    private String agentId;

    private String bankBranch;

    private String recreateFlag;

    private String tag;

    private String createTime;

    private String unionPayCode;

    private String realBankHolder;

    private String realBankAccount;

    /**
     * 资金类型
     */
    private String billFlag;

    public String getBillFlag() {
        return billFlag;
    }

    public void setBillFlag(String billFlag) {
        this.billFlag = billFlag;
    }

    public String getBankHolder() { return bankHolder; }

    public void setBankHolder(String bankHolder) { this.bankHolder = bankHolder; }

    public String getBankAccount() { return bankAccount; }

    public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }

    public String getAgentId() { return agentId; }

    public void setAgentId(String agentId) { this.agentId = agentId; }

    public String getBankBranch() { return bankBranch; }

    public void setBankBranch(String bankBranch) { this.bankBranch = bankBranch; }

    public String getRecreateFlag() { return recreateFlag; }

    public void setRecreateFlag(String recreateFlag) { this.recreateFlag = recreateFlag; }

    public String getTag() { return tag; }

    public void setTag(String tag) { this.tag = tag; }

    public String getCreateTime() { return createTime; }

    public void setCreateTime(String createTime) { this.createTime = createTime; }

    public String getUnionPayCode() { return unionPayCode; }

    public void setUnionPayCode(String unionPayCode) { this.unionPayCode = unionPayCode; }

    public String getRealBankHolder() { return realBankHolder; }
    @JSONField(name="bankHolderEnc")
    public void setRealBankHolder(String realBankHolder) { this.realBankHolder = realBankHolder; }

    public String getRealBankAccount() { return realBankAccount; }
    @JSONField(name="bankAccountEnc")
    public void setRealBankAccount(String realBankAccount) { this.realBankAccount = realBankAccount; }

    public String getTopAgentId() {
        return topAgentId;
    }

    public void setTopAgentId(String topAgentId) {
        this.topAgentId = topAgentId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getRemitNotifyUrl() {
        return remitNotifyUrl;
    }

    public void setRemitNotifyUrl(String remitNotifyUrl) {
        this.remitNotifyUrl = remitNotifyUrl;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getRemitDate() {
        return remitDate;
    }

    public void setRemitDate(String remitDate) {
        this.remitDate = remitDate;
    }

    public Long getPlanSettleAmount() {
        return planSettleAmount;
    }

    public void setPlanSettleAmount(Long planSettleAmount) {
        this.planSettleAmount = planSettleAmount;
    }

    public Long getSuspendSettleAmount() {
        return suspendSettleAmount;
    }

    public void setSuspendSettleAmount(Long suspendSettleAmount) {
        this.suspendSettleAmount = suspendSettleAmount;
    }

    public Long getRealSettleAmount() {
        return realSettleAmount;
    }

    public void setRealSettleAmount(Long realSettleAmount) {
        this.realSettleAmount = realSettleAmount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

//    @Override
//    public String toString() {
//        return "RemitNotifyMsgDto{" +
//                "topAgentId='" + topAgentId + '\'' +
//                ", merchantId='" + merchantId + '\'' +
//                ", remitNotifyUrl='" + remitNotifyUrl + '\'' +
//                ", billId='" + billId + '\'' +
//                ", settleType='" + settleType + '\'' +
//                ", remitDate='" + remitDate + '\'' +
//                ", settleDate='" + settleDate + '\'' +
//                ", remark='" + remark + '\'' +
//                ", planSettleAmount=" + planSettleAmount +
//                ", suspendSettleAmount=" + suspendSettleAmount +
//                ", realSettleAmount=" + realSettleAmount +
//                ", state='" + state + '\'' +
//                ", failReason='" + failReason + '\'' +
//                '}';
//    }
    //改版重写toString方法


    @Override
    public String toString() {
        return "RemitNotifyMsgDto{" +
                "topAgentId='" + topAgentId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", remitNotifyUrl='" + remitNotifyUrl + '\'' +
                ", billId='" + billId + '\'' +
                ", settleType='" + settleType + '\'' +
                ", remitDate='" + remitDate + '\'' +
                ", settleDate='" + settleDate + '\'' +
                ", remark='" + remark + '\'' +
                ", planSettleAmount=" + planSettleAmount +
                ", suspendSettleAmount=" + suspendSettleAmount +
                ", realSettleAmount=" + realSettleAmount +
                ", state='" + state + '\'' +
                ", failReason='" + failReason + '\'' +
                ", amount='" + amount + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", date='" + date + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", bankHolder='" + bankHolder + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", agentId='" + agentId + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", recreateFlag='" + recreateFlag + '\'' +
                ", tag='" + tag + '\'' +
                ", createTime='" + createTime + '\'' +
                ", unionPayCode='" + unionPayCode + '\'' +
                ", realBankHolder='" + realBankHolder + '\'' +
                ", realBankAccount='" + realBankAccount + '\'' +
                ", billFlag='" + billFlag + '\'' +
                '}';
    }

}
