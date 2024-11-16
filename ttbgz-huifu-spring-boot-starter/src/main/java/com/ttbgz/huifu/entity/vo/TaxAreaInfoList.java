package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 乐接活税源地列表
 *
 * @author ttbgz
 */
@Data
public class TaxAreaInfoList implements Serializable {
    /**
     * 税源地id（乐接活）
     * N 税源地id（乐接活）
     */
    @JSONField(name = "tax_area_id")
    private String taxAreaId;
    /**
     * 乐接活商事主体状态
     * N 0:待注册1:注册中2:注册成功3:注册失败4:园区处理中5:已注销6:注销失败；示例值：0
     */
    @JSONField(name = "status")
    private String status;
    /**
     * 状态描述
     * N 状态描述
     */
    @JSONField(name = "status_desc")
    private String statusDesc;
    /**
     * 乐接活实人状态
     * N 0：待实人1：认证成功2:认证失败
     */
    @JSONField(name = "auth_status")
    private String authStatus;
}
