package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 *
 * @author ttbgz
 */
@Getter
public enum IntoCcctDateTypeEnum {
    //D0：当日到账；当日交易资金当天可取现到账； T1：次工作日到账； D1：次自然日到账； DM：当日到账；到账资金不包括当天的交易资金；
    D0("D0","当日到账"),
    T1("T1","次工作日到账"),
    D1("D1","次自然日到账"),
    DM("DM","当日到账");

    private String code;
    private String desc;

    IntoCcctDateTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
