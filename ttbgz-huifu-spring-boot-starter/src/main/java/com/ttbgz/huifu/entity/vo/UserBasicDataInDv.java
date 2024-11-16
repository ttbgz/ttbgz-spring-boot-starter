package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ttbgz
 */
@Data
public class UserBasicDataInDv implements Serializable {
    /**
     * 请求流水号
     * 示例值：rQ2021121311173944134649875651
     */
    @NotNull(message = "请求流水号")
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     *请求日期
     * 格式yyyyMMdd；示例值：20220905
     */
    @NotNull(message = "请求日期")
    @JSONField(name = "req_date")
    private String reqDate;
    /**
     * 个人姓名 (必填)
     * 示例值：张三
     */
    @NotNull(message = "个人姓名")
    @JSONField(name = "name")
    private String name;
    /**
     * 个人证件类型 (必填)
     * 见《自然人证件类型》说明；示例值：00 <a href="https://paas.huifu.com/open/doc/api/#/api_ggcsbm?id=%e8%87%aa%e7%84%b6%e4%ba%ba%e8%af%81%e4%bb%b6%e7%b1%bb%e5%9e%8b">...</a>
     */
    @NotNull(message = "个人证件类型")
    @JSONField(name = "cert_type")
    private String certType;
    /**
     * 	个人证件号码(身份证)  (必填)
     *	示例值：320926198312024023
     */
    @NotNull(message = "个人证件号码")
    @JSONField(name = "cert_no")
    private String certNo;
    /**
     * 个人证件有效期类型 (必填)
     * 	1:长期有效 0:非长期有效；示例值：0
     */
    @NotNull(message = "个人证件有效期类型")
    @JSONField(name = "cert_validity_type")
    private String certValidityType;
    /**
     * 	个人证件有效期开始日期 (必填)
     * 	日期格式：yyyyMMdd；示例值：20220909
     */
    @NotNull(message = "个人证件有效期开始日期")
    @JSONField(name = "cert_begin_date")
    private String certBeginDate;
    /**
     *个人证件有效期截止日期
     * 日期格式：yyyyMMdd; 示例值：20330909 ；长期有效时可不填，非长期有效必填
     */
    @JSONField(name = "cert_end_date")
    private String certEndDate;
    /**
     * 	手机号 (必填)
     * 	示例值：13917354627
     */
    @NotNull(message = "手机号")
    @JSONField(name = "mobile_no")
    private String mobileNo;
    /**
     * 电子邮箱
     * 示例值：carl.chen@huifu.com
     */
    @JSONField(name = "email")
    private String email;
    /**
     *管理员账号
     * 示例值：Lg2022022201394910571
     */
    @JSONField(name = "login_name")
    private String loginName;
    /**
     * 	是否发送短信标识
     * 	Y:发送短信通知，N：不发送短信通知。默认不发送短信通知。示例值：Y
     */
    @JSONField(name = "sms_send_flag")
    private String smsSendFlag;
    /**
     * 拓展方字段
     * 如果该商户是第三方展业的可以填写拓展方的huifu_id;示例值：6666000123123123
     */
    @JSONField(name = "expand_id")
    private String expandId;
    /**
     * 文件列表 	jsonArray格式
     */
    @JSONField(name = "file_list")
    private List<UserBasicDataInDvFileList> fileList;
    /**
     * 地址
     * 开通中信E管家必填
     */
    @JSONField(name = "address")
    private String address;

    @Data
    class UserBasicDataInDvFileList {
        /**
         * 	文件类型
         * 	参见文件类型；示例值：F85
         */
        @JSONField(name = "file_type")
        private String fileType;
        /**
         * 	文件jfileID
         * 	图片上传接口生成的fileId；示例值：57cc7f00-600a-33ab-b614-6221bbf2e529
         */
        @JSONField(name = "file_id")
        private String fileId;
        /**
         * 文件名称
         * 	示例值：test42001.jpg
         */
        @JSONField(name = "file_name")
        private String fileName;
    }

    public Map<String, Object> getExtendInfos(){
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();

        // 个人证件有效期截止日期
        if (this.certEndDate!=null){
            extendInfoMap.put("cert_end_date", this.certEndDate);
        }
        // 电子邮箱
        if(this.email!=null){
            extendInfoMap.put("email", this.email);
        }
        // 管理员账号
        if (this.loginName!=null){
            extendInfoMap.put("login_name", this.loginName);
        }
        // 是否发送短信标识
        if (this.smsSendFlag!=null) {
            extendInfoMap.put("sms_send_flag", this.smsSendFlag);
        }
        // 拓展方字段
        if (this.expandId!=null){
            extendInfoMap.put("expand_id", this.expandId);
        }
        // 文件列表
        if (this.fileList!=null){
            extendInfoMap.put("file_list", getFileList());
        }
        return extendInfoMap;
    }


    private String getFileList() {
        if (this.fileList!=null && !this.fileList.isEmpty()){
            JSONArray dtoList = new JSONArray();
            for (UserBasicDataInDvFileList userBasicDataInDvFileList : fileList) {
                JSONObject dto = new JSONObject();
                // 文件类型
                dto.put("file_type",userBasicDataInDvFileList.getFileType());
                // 文件jfileID
                dto.put("file_id", userBasicDataInDvFileList.getFileId());
                // 文件名称
                dto.put("file_name", userBasicDataInDvFileList.getFileName());
                dtoList.add(dto);
            }
            return dtoList.toJSONString();
        }
      return null;
    }
}
