package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 * 通知状态枚举
 * @author luogong
 */
@Getter
public enum NotifyTypeEnum {
    //1：通道通知，2：账务通知；示例值：1
    T_NOTIFY("1","通道通知"),
    B_NOTIFY("2","账务通知");

    private final String code;
    private final String desc;

    NotifyTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
