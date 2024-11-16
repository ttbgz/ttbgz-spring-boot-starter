package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONField;
import com.ttbgz.huifu.enums.TradeTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 聚合支付入参
 * 属性不是完整的，有接入的人员根据自身需求进行修改
 * @author suetian
 *
 */
@Data
public class TradePaymentPay implements Serializable {

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
     * 商户号
     */
    @NotBlank(message = "商户号不能为空")
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 	账户号
     * 	可指定收款账户号，仅支持基本户、现金户，不填默认为基本户；
     *   示例值：F00598600
     */
    @JSONField(name = "acct_id")
    private String acctId;

    /**
     * 商品描述
     * 示例值：XX商品
     */
    @NotBlank(message = "商品描述不能为空")
    @JSONField(name = "goods_desc")
    private String goodsDesc;

    /**
     * 交易类型
     */
    @NotNull(message = "交易类型不能为空")
    @JSONField(name = "trade_type")
    private TradeTypeEnum tradeType;
    /**
     * 交易金额 单位元
     * 单位元，需保留小数点后两位，示例值：1000.00，最低传入0.01；
     */
    @NotBlank(message = "交易金额不能为空")
    @JSONField(name = "trans_amt")
    private String transAmt;

    /**
     * 回调地址 异步通知地址
     */
    @JSONField(name = "notify_url")
    private String notifyUrl;

    @JSONField(name = "wx_data")
    private WxData wxData;

    @JSONField(name = "remark")
    private String remark;

    /**
     * 非必填字段
     * @return
     */
    public  Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();

        if (this.acctId!=null){
            extendInfoMap.put("acct_id", this.acctId);
        }
        if (this.notifyUrl!=null){
            extendInfoMap.put("notify_url", this.notifyUrl);
        }
        //对象处理
        if (this.wxData!=null){
            String string = JSON.toJSONString(this.wxData, JSONWriter.Feature.IgnoreNoneSerializable);
            extendInfoMap.put("wx_data", JSON.parseObject(string, JSONObject.class));
        }
        if (this.remark!=null){
            extendInfoMap.put("remark", this.remark);
        }
        return extendInfoMap;
    }

}
