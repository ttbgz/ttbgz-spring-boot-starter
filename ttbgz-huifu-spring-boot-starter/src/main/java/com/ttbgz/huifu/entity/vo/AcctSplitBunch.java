package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ttbgz
 */
@Data
public class AcctSplitBunch implements Serializable {

    /**
     *	分账明细
     */
    @JSONField(name = "acct_infos")
    private List<AcctInfos> acctInfos;
    /**
     * 	百分比分账标志  Y:使用百分比分账；示例值：Y
     */
    @JSONField(name = "percentage_flag")
    private String percentageFlag;
    /**
     * 	是否净值分账 	Y:使用净值分账，仅在交易手续费由出款方承担且使用百分比分账时起作用；示例值：Y
     */
    @JSONField(name = "is_clean_split")
    private String isCleanSplit;

}
