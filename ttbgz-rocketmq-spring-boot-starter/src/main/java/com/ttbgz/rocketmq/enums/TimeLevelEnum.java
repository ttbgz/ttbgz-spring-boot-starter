package com.ttbgz.rocketmq.enums;

import lombok.Getter;

/**
 * rocketMq 延迟投递等级枚举
 *
 * @author ttbgz
 */
@Getter
public enum TimeLevelEnum {
    SECOND_ONE(1, "1秒"),
    SECOND_FIVE(2, "5秒"),
    SECOND_TEN(3, "10秒"),
    SECOND_THIRTY(4, "30秒"),
    MINUTE_ONE(5, "1分钟"),
    MINUTE_TWO(6, "2分钟"),
    MINUTE_THREE(7, "3分钟"),
    MINUTE_FOUR(8, "4分钟"),
    MINUTE_FIVE(9, "5分钟"),
    MINUTE_SIX(10, "6分钟"),
    MINUTE_SEVEN(11, "7分钟"),
    MINUTE_EIGHT(12, "8分钟"),
    MINUTE_NINE(13, "9分钟"),
    MINUTE_TEN(14, "10分钟"),
    MINUTE_TWENTY(15, "20分钟"),
    MINUTE_THIRTY(16, "30分钟"),
    HOUR_ONE(17, "1小时"),
    HOUR_TWO(18, "2小时");

    private final Integer level;
    private final String desc;

    TimeLevelEnum(Integer level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
