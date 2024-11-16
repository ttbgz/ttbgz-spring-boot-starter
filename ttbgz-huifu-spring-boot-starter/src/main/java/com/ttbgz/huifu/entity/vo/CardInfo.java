package com.ttbgz.huifu.entity.vo;


import com.alibaba.fastjson2.annotation.JSONField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 结算卡信息
 * @author ttbgz
 */
@Data
public class CardInfo implements Serializable {

    /**
     * 卡类型 String  1 Y 0：对公，1：对私，2：对私非法人；个人商户/用户不支持对公类型，对私非法人类型示例值：0
     */
    @NotBlank(message = "卡类型不能为空")
    @JSONField(name = "card_type")
    private String cardType;
    /**
     * 卡户名 String  128 Y 持卡人姓名；示例值：上海汇付支付服务公司
     */
    @NotBlank(message = "卡户名不能为空")
    @JSONField(name = "card_name")
    private String cardName;
    /**
     * 卡号  String  32  Y 银行卡号；示例值：0206014170008888
     */
    @NotBlank(message = "卡号不能为空")
    @JSONField(name = "card_no")
    private String cardNo;
    /**
     * 银行所在省 String  6 Y 地区编码内容较多，请下载查询 下载；示例值：100000
     */
    @NotBlank(message = "省不能为空")
    @JSONField(name = "prov_id")
    private String provId;
    /**
     * 银行所在市 String  6 Y 地区编码内容较多，请下载查询 下载；示例值：110000
     */
    @NotBlank(message = "市不能为空")
    @JSONField(name = "area_id")
    private String areaId;

    /**
     * 银行号 String  8 C 当card_type=0时必填，对私可以为空点击查看；示例值：01040000
     */
    @JSONField(name = "bank_code")
    private String bankCode;
    /**
     * 支行联行号 String  12  C 当card_type=0时必填，点击查看；示例值：103124075619
     */
    @JSONField(name = "branch_code")
    private String branchCode;
    /**
     * 持卡人证件类型 String  2 C 对私必填；参见《自然人证件类型》说明；示例值：00
     */
    @JSONField(name = "cert_type")
    private String certType;
    /**
     * 持卡人证件号码 String  32  C 对私必填； 如:证件类型为身份证, 则填写身份证号码；示例值：320926198412032059
     */
    @JSONField(name = "cert_no")
    private String certNo;
    /**
     * 持卡人证件有效期类型  String  1 C 对私必填；1：长期有效；0：非长期有效；示例值：0
     */
    @JSONField(name = "cert_validity_type")
    private String certValidityType;
    /**
     * 持卡人证件有效期（起始）  String  8 C 对私必填；日期格式：yyyyMMdd，示例值：20110112
     */
    @JSONField(name = "cert_begin_date")
    private String certBeginDate;
    /**
     * 持卡人证件有效期（截止）  String  8 C 当cert_validity_type=0时必须填写；日期格式yyyyMMdd，示例值：20110112 当cert_validity_type=1可不填
     */
    @JSONField(name = "cert_end_date")
    private String certEndDate;
    /**
     * 银行卡绑定手机号  String  11  N 11位数字，示例值：18611111111
     */
    @JSONField(name = "mp")
    private String mp;
    /**
     * 默认结算卡标志 String  1 N 是否为默认结算卡标志；Y:是 N:否(为空默认)；示例值：Y
     */
    @JSONField(name = "is_settle_default")
    private String isSettleDefault;

    //返回值信息------------------
    /**
     * 绑卡序列号
     */
    @JSONField(name = "token_no")
    private String tokenNo;
    /**
     * 银行卡绑定状态
     */
    @JSONField(name = "status")
    private String status;

}
