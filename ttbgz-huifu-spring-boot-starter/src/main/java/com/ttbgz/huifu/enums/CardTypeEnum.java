package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 * 卡类型枚举
 * @author ttbgz
 */
@Getter
public enum CardTypeEnum {
   // 0：对公，1：对私，2：对私非法人；个人商户/用户不支持对公类型，对私非法人类型
    CARD_TYPE_PUBLIC("0","对公"),
    CARD_TYPE_PRIVATE("1","对私"),
    CARD_TYPE_ILLEGAL("2","对私非法人");

    private final String code;
    private final String desc;

    CardTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
