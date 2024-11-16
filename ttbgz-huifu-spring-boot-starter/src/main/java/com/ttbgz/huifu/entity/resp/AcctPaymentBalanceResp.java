package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangyongjie
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AcctPaymentBalanceResp extends HuiFuResp implements Serializable {

    /**
     * 	请求日期
     * 	交易时传入，原样返回；示例值：20221023
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     *  请求流水号
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;

    @JSONField(name = "acctInfo_list")
    private List<AcctInfo> acctInfoList;

}
