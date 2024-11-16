package com.ttbgz.leshua.sdk.api.response.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class SaasMchCallBackModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7044939364082281392L;

	private transient String topAgentId;

	private String merchantId;

	private String agentId;

	private AuditInfo auditInfo;

	public String getMerchantId() {
		return merchantId;
	}

	public String getTopAgentId() {
		return topAgentId;
	}

	public void setTopAgentId(String topAgentId) {
		this.topAgentId = topAgentId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
