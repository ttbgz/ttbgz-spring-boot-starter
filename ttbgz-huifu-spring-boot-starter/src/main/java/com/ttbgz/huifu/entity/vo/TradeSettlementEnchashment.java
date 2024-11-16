package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ttbgz.huifu.enums.IntoCcctDateTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户取现
 *
 * @author ttbgz
 */
@Data
public class TradeSettlementEnchashment implements Serializable {
    /**
     * 请求日期
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 请求流水号
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 取现金额
     */
    @NotBlank(message = "取现金额不能为空")
    @JSONField(name = "cash_amt")
    private String cashAmt;
    /**
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 账户号
     */
    @JSONField(name = "acct_id")
    private String acctId;
    /**
     * 到账日期类型
     */
    @NotNull(message = "到账日期类型不能为空")
    @JSONField(name = "into_acct_date_type")
    private IntoCcctDateTypeEnum intoAcctDateType;
    /**
     * 取现卡序列号
     */
    @NotBlank(message = "取现卡序列号不能为空")
    @JSONField(name = "token_no")
    private String tokenNo;
    /**
     * 取现渠道
     */
    @JSONField(name = "enchashment_channel")
    private String enchashmentChannel;
    /**
     * 备注
     */
    @JSONField(name = "remark")
    private String remark;
    /**
     * 异步通知地址
     */
    @JSONField(name = "notify_url")
    private String notifyUrl;

    /**
     * 非必填字段
     * @return
     */
    public Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
        // 异步通知地址
        if (this.notifyUrl!=null){
            extendInfoMap.put("notify_url", this.notifyUrl);
        }
        // 备注
        if (this.remark!=null){
            extendInfoMap.put("remark", this.remark);
        }
        // 账户号
        if (this.acctId!=null){
            extendInfoMap.put("acct_id", this.acctId);
        }
        //取现渠道
        if (this.enchashmentChannel!=null){
            extendInfoMap.put("enchashment_channel", this.enchashmentChannel);
        }
        return extendInfoMap;
    }

}
