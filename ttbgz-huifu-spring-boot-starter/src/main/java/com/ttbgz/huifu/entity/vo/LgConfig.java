package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 灵工配置
 * @author Administrator
 */
@Data
public class LgConfig implements Serializable {

    /**
     * 是否开通灵工
     * Y-开通、N-未开通，乐接活和汇优财只要有一个开通即为Y；示例值：Y
     */
    @JSONField(name = "open_flag")
    private String openFlag;
    /**
     * 汇优财配置
     * Y-开通、N-未开通，乐接活和汇优财只要有一个开通即为Y；示例值：Y
     */
    @JSONField(name = "hyc_config")
    private HycConfig hycConfig;

    /**
     * 乐接活配置
     */
    @JSONField(name = "ljh_config")
    private LjhConfig ljhConfig;
}
