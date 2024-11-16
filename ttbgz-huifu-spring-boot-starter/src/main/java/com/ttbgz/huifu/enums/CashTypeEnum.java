package com.ttbgz.huifu.enums;


import lombok.Getter;

/**
 *
 * 提现类型枚举
 * @author ttbgz
 */
@Getter
public enum CashTypeEnum {
    T1("T1","下一工作日到银行账户"),
    D1("D1","下一自然日到银行账户"),
    D0("D0","当日到银行账户"),
    DM("DM","当日到账");

    private final String code;
    private final String desc;

    CashTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
