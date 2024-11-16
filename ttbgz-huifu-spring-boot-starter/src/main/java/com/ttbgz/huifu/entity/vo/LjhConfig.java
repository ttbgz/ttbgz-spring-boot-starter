package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 乐接活配置
 * @author ttbgz
 */
@Data
public class LjhConfig implements Serializable {

    /**
     * 	乐接活税源地列表
     */
    @JSONField(name = "tax_area_info_list")
    private List<TaxAreaInfoList> taxAreaInfoList;
}
