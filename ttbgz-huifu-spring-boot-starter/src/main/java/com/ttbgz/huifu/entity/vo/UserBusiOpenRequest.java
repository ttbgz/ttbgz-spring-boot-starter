package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户业务入住
 * @author ttbgz
 */
@Data
public class UserBusiOpenRequest implements Serializable {
    /**
     * 汇付ID
     */
    @NotBlank(message = "汇付ID不能为空")
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     * 请求流水号
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 请求日期
     */
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 渠道商/商户汇付Id
     */
    @NotBlank(message = "渠道商/商户汇付Id不能为空")
    @JSONField(name = "upper_huifu_id")
    private String upperHuifuId;

    /**
     * 	结算信息配置
     */
    @JSONField(name = "settle_config")
    private SettleConfig settleConfig;

    /**
     * 结算卡信息
     */
    @JSONField(name = "card_info")
    private CardInfo cardInfo;
    /**
     * 	取现配置列表
     */
    @JSONField(name = "cash_config")
    private List<CashConfig> cashConfigArray;
    /**
     * 	延迟入账开关
     * 	N：否 Y：是；示例值：Y
     */
    @JSONField(name = "delay_flag")
    private String delayFlag;
    /**
     *  灵活用工开关
     * N：否（默认） Y：是；示例值：Y
     * 1、个人证件类型必须为身份证类型。
     * 2、结算卡信息可不填；若填写则结算类型不能为对公，且结算账户名与个人姓名一致。
     *
     */
    @JSONField(name = "open_tax_flag")
    private String openTaxFlag;
    /**
     * 	异步请求地址
     *  为空时不推送异步消息 格式：http://消息接收地址，示例值：http://service.example.com/to/path
     */
    @JSONField(name = "async_return_url")
    private String asyncReturnUrl;

    /**
     * 非必填字段
     * @return
     */
    public Map<String, Object> getExtendInfos(){

        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();

        if(this.delayFlag!=null){
            extendInfoMap.put("delay_flag",this.delayFlag);
        }
        if(this.openTaxFlag!=null){
            extendInfoMap.put("open_tax_flag",this.openTaxFlag);
        }
        if(this.asyncReturnUrl!=null){
            extendInfoMap.put("async_return_url",this.asyncReturnUrl);
        }

        // 结算信息配置
        if(this.settleConfig!=null){
            // SerializerFeature.SkipTransientField
//            String string =JSON.toJSONString(this.settleConfig, SerializerFeature.SkipTransientField); SerializerFeature.SkipTransientField
                String string =JSON.toJSONString(this.settleConfig, JSONWriter.Feature.IgnoreNoneSerializable);
            extendInfoMap.put("settle_config", JSON.parseObject(string, JSONObject.class));
        }
        // 结算卡信息
        if (this.cardInfo!=null){
            String string =JSON.toJSONString(this.cardInfo, JSONWriter.Feature.IgnoreNoneSerializable);
            extendInfoMap.put("card_info", JSON.parseObject(string, JSONObject.class));
        }
        //取现配置列表
        if (this.cashConfigArray!=null && !this.cashConfigArray.isEmpty()){
            String string =JSON.toJSONString(this.cashConfigArray,JSONWriter.Feature.IgnoreNoneSerializable);
            extendInfoMap.put("cash_config", JSON.parseObject(string, JSONArray.class));
        }
        // extendInfoMap.put("&lt;span class&#x3D;&quot;extend cash_config&quot;&gt;cash_config&lt;/span&gt;", "");
        // 文件列表
        // extendInfoMap.put("&lt;span class&#x3D;&quot;extend file_list&quot;&gt;file_list&lt;/span&gt;", "");
        // 延迟入账开关
        // extendInfoMap.put("delay_flag", "");
        return extendInfoMap;
    }

}
