package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 安全信息
 *
 * @author Administrator
 */
@Data
public class RiskCheckData implements Serializable {

    /**
     *sub_product	产品子类
     * String	20	N	示例值：1
     */
    @JSONField(name = "sub_product")
    private String subProduct;

    /**
     *transfer_type	转账原因
     * String	2	Y	01：卡券推广类；02：卡券核销类；03：消费；04：工资代发；05：分润；06：灵活用工；示例值：01
     */
    @JSONField(name = "transfer_type")
    private String transferType;

    /**
     *latitude	纬度
     * String	32	N	格式：+表示北纬，-表示南纬。纬度整数位不超过2位，小数位不超过6位。示例值：+37.12
     */
    @JSONField(name = "latitude")
    private String latitude;

    /**
     *longitude	经度
     * String	32	N	格式：+表示东经，-表示西经；经度整数位不超过3位，小数位不超过5位；示例值：-121.213
     */
    @JSONField(name = "longitude")
    private String longitude;

    /**
     *base_station	基站地址
     * String	32	N	【mcc】+【mnc】+【location_cd】+【lbs_num】
     */
    @JSONField(name = "base_station")
    private String baseStation;

    /**
     *ip_addr	IP地址
     * String	32	N	示例值：172.28.52.52；经纬度、基站地址、IP地址三组信息至少填写一组
     */
    @JSONField(name = "ip_addr")
    private String ipAddr;
}
