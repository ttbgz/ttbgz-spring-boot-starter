package com.ttbgz.leshua.sdk.api.response.dto;

import com.alibaba.fastjson.JSON;

public class AuditQry {
    String merchantStatus;//审核状态
    /*
    REJECTED 退回
    REVIEW 待人工检查
    PASSED 通过
    UNKNOWN 未知
    ADD_INFO 待完善资料
    AUDITING 待审核
     */
    String auditMsg;//商户审核信息
    JSON rejectReasonType;//商户审核分类
    /*
    MCH_INFO_ERROR:商户信息错误
    LECENSE_ERROR:营业执照信息错误
    CERTIFICATE_ERROR:证件信息错误
    ACCOUNT_INFO_ERROR:结算账户信息错误
    SYSTEM_REJECT:系统拒绝
    OTHER_INFO_ERROR:其他信息错误
     */
    String refusalReason;//拒绝驳回原因
    String auditDateTime;//审核时间
    String auditRemark;//商户审核备注

    public String getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(String merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getAuditMsg() {
        return auditMsg;
    }

    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg;
    }

    public JSON getRejectReasonType() {
        return rejectReasonType;
    }

    public void setRejectReasonType(JSON rejectReasonType) {
        this.rejectReasonType = rejectReasonType;
    }

    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public String getAuditDateTime() {
        return auditDateTime;
    }

    public void setAuditDateTime(String auditDateTime) {
        this.auditDateTime = auditDateTime;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Override
    public String toString() {
        return "AuditQry:{" +
                "merchantStatus='" + merchantStatus + '\'' +
                ", auditMsg='" + auditMsg + '\'' +
                ", rejectReasonType=" + rejectReasonType +
                ", refusalReason='" + refusalReason + '\'' +
                ", auditDateTime='" + auditDateTime + '\'' +
                ", auditRemark='" + auditRemark + '\'' +
                '}';
    }
}
