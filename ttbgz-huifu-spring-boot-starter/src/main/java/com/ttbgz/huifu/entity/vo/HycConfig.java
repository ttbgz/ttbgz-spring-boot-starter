package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 汇优财配置
 * @author ttbgz
 */
@Data
public class HycConfig implements Serializable {

    /**
     * 汇优财开户状态
     * 	1-待开户 2-开户成功待签约 3-开户失败 4-签约成功 5-签约失败；示例值：1
     */
    @JSONField(name = "status")
    private String status;

    /**
     * 汇优财开户状态描述
     *
     */
    @JSONField(name = "status_desc")
    private String statusDesc;
}
