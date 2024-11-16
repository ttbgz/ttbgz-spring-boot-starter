package com.ttbgz.websocke.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author ttbgz
 */
@Data
@Builder
public class MsgResult<T> {
    /**
     *  code编码 0 心跳 1内容
     */
    private Integer code;

    private T data;

    public static <T> MsgResult<T> newInstance(int code, T content) {
        return MsgResult.<T>builder()
                .code(code)
                .data(content)
                .build();
    }
}
