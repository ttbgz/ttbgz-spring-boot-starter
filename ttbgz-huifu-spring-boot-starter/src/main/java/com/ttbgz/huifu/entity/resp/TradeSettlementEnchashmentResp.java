package com.ttbgz.huifu.entity.resp;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 账户提现响应实体
 * @author ttbgz
 */
@Data
public class TradeSettlementEnchashmentResp extends HuiFuResp implements Serializable {
    /**
     * 请求日期
     *  8 N 格式：yyyyMMdd；示例值：20211123
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 请求流水号
     *  128 N 示例值：202109160899013231200005
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 汇付全局流水号
     *  128 N 示例值：002900TOP3A221112165433P410ac139c1300001
     */
    @JSONField(name = "hf_seq_id")
    private String hfSeqId;
    /**
     * 交易状态
     *  1 Y S：成功 F：失败 P：处理中；示例值：S
     */
    @JSONField(name = "trans_stat")
    private String transStat;
    /**
     * 商户号/机构号
     *  32  N 汇付分配的商户号/机构号，示例值：6666000109812123
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 账户号
     *  32  N 可指定账户号，仅支持基本户、现金户，不填默认为基本户；示例值：F00598600
     */
    @JSONField(name = "acct_id")
    private String acctId;

}