package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * V2用户开通请求响应实体
 * @author ttbgz
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserBusiOpenRequestResp extends HuiFuResp implements Serializable {

    /**
     * 	汇付ID
     */
    @JSONField(name = "huifu_id")
    private String huifuId;
    /**
     *	取现卡序列号
     *	取现卡序列号，交易时使用；示例值：10000406827
     */
    @JSONField(name = "token_no")
    private String tokenNo;
    /**
     * 	申请单号
     * 	返回审核中时有值，业务申请单号；示例值：2024022934731647
     */
    @JSONField(name = "apply_no")
    private String applyNo;
    /**
     *  业务配置结果状态列表
     *  jsonArray格式
     */
    @JSONField(name = "resp_business")
    private List<RespBusinessArray> respBusiness;
    /**
     * 	灵工场景下，且合作平台为乐接活时，返回该参数。
     *
     */
    @JSONField(name = "resp_ljh")
    private List<LjhResponseArray> ljhResponse;

    /**
     * 业务配置结果状态列表
     */
    @Data
    public class RespBusinessArray{
        /**
         *  配置类型
         * 1、绑卡信息；2、取现配置；3、结算信息配置；5、灵工业务配置；示例值：1
         */

        private String type;
        /**
         *配置状态
         * S:成功，F:失败；示例值：S
         */
        private String code;
        /**
         *配置返回信息
         * 业务响应信息；示例值：
         */
        private String msg;
    }
    @Data
    public class LjhResponseArray{
        /**
         * 商事id
         */
        @JSONField(name = "ac_id")
        private String acId;
        /**
         * 商事主体状态
         */
        private String status;
        /**
         * 注册状态描述
         */
        @JSONField(name = "status_desc")
        private String statusDesc;
        /**
         * 乐接活用户id
         */
        @JSONField(name = "user_id")
        private String userId;
    }

}
