package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 企业用户基本信息
 * @author ttbgz
 */
@Data
public class EntBaseInfo implements Serializable {
    /**
     * 企业用户名称
     *   128 Y 企业用户名称，当为汉字时以2个字符计算；示例值：上海汇付支付服务公司
     */
    @JSONField(name = "reg_name")
    private String regName;
    /**
     * 营业执照编号
     *   20  Y 示例值：92650109MA79R8E308
     */
    @JSONField(name = "license_code")
    private String licenseCode;
    /**
     * 证照有效期类型
     *   1 Y 1：长期有效；0：非长期有效；示例值：1
     */
    @JSONField(name = "license_validity_type")
    private String licenseValidityType;
    /**
     * 证照有效期起始日期
     *   8 Y 有效期格式：yyyyMMdd；示例值：20220909
     */
    @JSONField(name = "license_begin_date")
    private String licenseBeginDate;
    /**
     * 证照有效期结束日期
     *   8 N 有效期格式：yyyyMMdd；示例值：20420909
     */
    @JSONField(name = "license_end_date")
    private String licenseEndDate;
    /**
     * 注册地址(省)
     *   6 Y 地区编码内容较多，请下载查询 下载 ；示例值：310000
     */
    @JSONField(name = "reg_prov_id")
    private String regProvId;
    /**
     * 注册地址(市)
     *   6 Y 地区编码内容较多，请下载查询 下载 ；示例值：310100
     */
    @JSONField(name = "reg_area_id")
    private String regAreaId;
    /**
     * 注册地址(区)
     *   6 Y 地区编码内容较多，请下载查询 下载 ；示例值：310101
     */
    @JSONField(name = "reg_district_id")
    private String regDistrictId;
    /**
     * 注册地址(详细信息)
     *   256 Y 示例值：上海市徐汇区XX路XX号
     */
    @JSONField(name = "reg_detail")
    private String regDetail;
    /**
     * 法人姓名
     *   32  Y 示例值：张三
     */
    @JSONField(name = "legal_name")
    private String legalName;
    /**
     * 法人证件类型
     *   2 Y 参见《自然人证件类型》说明 ；示例值：00
     */
    @JSONField(name = "legal_cert_type")
    private String legalCertType;
    /**
     * 法人证件号码
     *   32  Y 示例值：3209026198312183829
     */
    @JSONField(name = "legal_cert_no")
    private String legalCertNo;
    /**
     * 法人证件有效期类型
     *   1 Y 1：长期有效； 0：非长期有效；示例值：0
     */
    @JSONField(name = "legal_cert_validity_type")
    private String legalCertValidityType;
    /**
     * 法人证件有效期开始日期
     *   8 Y 有效期格式：yyyyMMdd；示例值：20220909
     */
    @JSONField(name = "legal_cert_begin_date")
    private String legalCertBeginDate;
    /**
     * 法人证件有效期截止日期
     *   8 N 有效期格式：yyyyMMdd；示例值：20340909
     */
    @JSONField(name = "legal_cert_end_date")
    private String legalCertEndDate;
    /**
     * 联系人姓名
     *   32  Y 示例值：李四
     */
    @JSONField(name = "contact_name ")
    private String contactName;
    /**
     * 联系人手机号
     *   11  Y 11位数字；示例值：18611111111
     */
    @JSONField(name = "contact_mobile_no")
    private String contactMobileNo;
    /**
     * 联系人电子邮箱
     *   64  N 示例值：carl.chen@huifu.com
     */
    @JSONField(name = "contact_email")
    private String contactEmail;
    /**
     * 管理员账号
     *   32  N 示例值：cwd10012423
     */
    @JSONField(name = "login_name")
    private String loginName;
    /**
     * 附件资料列表
     *
     */
    @JSONField(name = "file_list")
    private List<FileList> fileList;
}
