package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ttbgz
 */
@Data
public class AcctInfos implements Serializable {

    /**
     * 分账金额
     */
    @JSONField(name = "div_amt")
    private String divAmt;
    /**
     *分账接收方ID
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     *	账户号
     */
    @JSONField(name = "acct_id")
    private String acctId;
    /**
     * 	分账百分比%
     */
    @JSONField(name = "percentage_div")
    private String percentageDiv;
}
