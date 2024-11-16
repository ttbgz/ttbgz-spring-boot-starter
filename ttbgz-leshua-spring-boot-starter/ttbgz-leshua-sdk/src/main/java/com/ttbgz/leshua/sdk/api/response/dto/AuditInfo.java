package com.ttbgz.leshua.sdk.api.response.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class AuditInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8702736267147203594L;

	private String auditMsg = "";

	private String auditStatus = "";

	private String auditDateTime = "";

	private  String rejectReasonType ="";

	private  String refusalReason ="";

	public String getRejectReasonType() { return rejectReasonType; }

	public void setRejectReasonType(String rejectReasonType) { this.rejectReasonType = rejectReasonType; }

	public String getRefusalReason() { return refusalReason; }

	public void setRefusalReason(String refusalReason) { this.refusalReason = refusalReason; }

	public String getAuditMsg() {
		return auditMsg;
	}

	public void setAuditMsg(String auditMsg) {
		this.auditMsg = auditMsg;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditDateTime() {
		return auditDateTime;
	}

	public void setAuditDateTime(String auditDateTime) {
		this.auditDateTime = auditDateTime;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
