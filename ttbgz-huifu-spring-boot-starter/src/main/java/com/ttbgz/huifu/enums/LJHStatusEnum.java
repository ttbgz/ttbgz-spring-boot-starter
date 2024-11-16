package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 *乐接活 状态
 * @author Administrator
 */

@Getter
public enum LJHStatusEnum {
    UNREGISTERED(0,"待注册"),
    REGISTERING(1,"注册中"),
    REGISTERED(2,"注册成功"),
    REGISTER_FAIL(3,"注册失败"),
    PARKING(4,"园区处理中"),
    CANCELLED(5,"已注销"),
    CANCEL_FAIL(6,"注销失败");

    private int code;
    private String desc;

    LJHStatusEnum(int code, String desc) {
        this.code = code;
        this.desc =desc;
    }
}
