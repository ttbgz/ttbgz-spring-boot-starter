package com.ttbgz.huifu.utils;

import com.alibaba.fastjson2.JSON;
import com.ttbgz.huifu.utils.entity.HfPayRecordPojo;

/**
 * 汇付回调转换器
 *
 * @author Administrator
 */
public class HuiFuUtils {

    /**
     * 支付记录转换
     *
     * @param respData
     * @return
     */
    public static HfPayRecordPojo payNotifyConvert(String respData) {
        return JSON.parseObject(respData, HfPayRecordPojo.class);
    }


}
