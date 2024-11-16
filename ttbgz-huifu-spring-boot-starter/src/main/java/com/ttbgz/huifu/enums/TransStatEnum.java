package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 * @author ttbgz
 */
@Getter
public enum TransStatEnum {
    //P:处理中、S:成功、F:失败；交易状态以此字段为准
    P("P","处理中"),
    S("S","成功"),
    F("F","失败");

    private final String code;
    private final String desc;

    TransStatEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
