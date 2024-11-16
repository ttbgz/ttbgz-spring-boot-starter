package com.ttbgz.rocketmq.entity;

import lombok.Getter;

import java.lang.reflect.Method;

/**
 * 消费者方法和bean的封装
 * @author ttbgz
 */
@Getter
public class MethodWithBean {
    private final Method method;
    private final Object bean;

    public MethodWithBean(Method method, Object bean) {
        this.method = method;
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public Object getBean() {
        return bean;
    }
}
