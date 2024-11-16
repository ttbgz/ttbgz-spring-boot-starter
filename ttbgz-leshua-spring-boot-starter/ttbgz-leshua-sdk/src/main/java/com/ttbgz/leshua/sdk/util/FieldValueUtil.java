package com.ttbgz.leshua.sdk.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @Author zonghuiTan
 * @Description // 利用反射获取设计和获取 value值
 **/
public class FieldValueUtil {
    private static Logger logger = LoggerFactory.getLogger(FieldValueUtil.class);

    /**
     * @Author zonghuiTan
     * @Description // 动态的设置 值
     **/
    public static <T> void setValue(T t, String fieldName, Object fieldValue) {
        if (null == fieldValue) {
            return;
        }
        Class<?> clazz = t.getClass();
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            try {
                field.set(t, fieldValue);
            } catch (IllegalAccessException e) {
                logger.error("field: {} 转换失败", fieldName);
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        }

    }

}
