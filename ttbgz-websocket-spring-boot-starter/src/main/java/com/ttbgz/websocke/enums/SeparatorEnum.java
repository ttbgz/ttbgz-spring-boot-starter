package com.ttbgz.websocke.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeparatorEnum {
    /**
     * 逗号
     */
    COMMA(","),
    SLASH("/"),
    LINE("\\|"),
    QUESTION("?"),
    SEMICOLON(";"),
    EQUALS("="),
    POUND("#"),
    MINUS("-"),
    AND("&"),
    UNDERLINE("_"),
    SPOT("."),
    SPOT_E("\\."),
    APOSTROPHE("'"),
    PERCENTAGE("%"),
    GT(">");

    /**
     * 值
     */
    public final String code;
}