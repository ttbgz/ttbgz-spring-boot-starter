package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 个人用户基本信息
 * @author ttbgz
 */
@Data
public class IndvBaseInfo implements Serializable {
    /**
     * 个人姓名
     * 32  Y 示例值：张三
     */
    @JSONField(schema = "name")
    private String name;
    /**
     * 个人证件类型
     * 2 Y 参见《自然人证件类型》说明；示例值：00
     */
    @JSONField(schema = "cert_type")
    private String certType;
    /**
     * 个人证件号码
     * 32  Y 示例值：320928198412030384
     */
    @JSONField(schema = "cert_no")
    private String certNo;
    /**
     * 个人证件有效期类型
     * 1 Y 1：长期有效；0：非长期有效；示例值：0
     */
    @JSONField(schema = "cert_validity_type")
    private String certValidityType;
    /**
     * 个人证件有效期开始日期
     * 8 Y 有效期格式：yyyyMMdd；示例值：20220909
     */
    @JSONField(schema = "cert_begin_date")
    private String certBeginDate;
    /**
     * 个人证件有效期截止日期
     * 8 N 有效期格式：yyyyMMdd；示例值：20340909
     */
    @JSONField(schema = "cert_end_date")
    private String certEndDate;
    /**
     * 手机号
     * 11  Y 11位数字，示例值：18611111111
     */
    @JSONField(schema = "mobile_no")
    private String mobileNo;
    /**
     * 电子邮箱
     * 64  N 示例值：carl.chen@huifu.com
     */
    @JSONField(schema = "email")
    private String email;
    /**
     * 管理员账号
     * 32  N 示例值：cws48304494532
     */
    @JSONField(schema = "login_name")
    private String loginName;

    /**
     * 附件资料列表
     *
     */
    @JSONField(name = "file_list")
    private List<FileList> fileList;

    /**
     * 灵工配置
     */
    @JSONField(name = "lg_config")
    private List<FileList> lgConfig;

    /**
     * 结算卡信息
     */
    @JSONField(name = "card_info")
    private CardInfo cardInfo;
    /**
     * 结算信息配置
     */
    @JSONField(name = "settle_config")
    private SettleConfig settleConfig;
    /**
     * 取现配置列表
     */
    @JSONField(name = "qry_cash_config_list")
    private List<CashConfig> qryCashConfigList;
    /**
     * 取现卡信息
     */
    @JSONField(name = "qry_cash_card_info_list")
    private List<CardInfo> qryCashCardInfoList;

}

