package com.ttbgz.rocketmq.config;

import com.ttbgz.rocketmq.anno.RocketMqListener;
import com.ttbgz.rocketmq.consumer.ConsumerConcurrently;
import com.ttbgz.rocketmq.consumer.ConsumerOrderly;
import com.ttbgz.rocketmq.entity.MethodWithBean;
import com.ttbgz.rocketmq.entity.RocketMessage;
import com.ttbgz.rocketmq.enums.MessageListenerEnum;
import com.ttbgz.rocketmq.properties.CustomerProperties;
import com.ttbgz.rocketmq.properties.RocketMqProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Component
@Slf4j
public class RocketMqListenerInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private  RocketMqProperties rocketMqProperties;
    private Map<String, CustomerProperties> map=new HashMap<>();

    public RocketMqListenerInitializer(RocketMqProperties rocketMqProperties){
        this.rocketMqProperties=rocketMqProperties;
        //获取配置的消费者
        List<CustomerProperties> customerConfig = Optional.ofNullable(rocketMqProperties.getCustomer()).orElseGet(ArrayList::new);
        log.info("获取到消费者配置{}个", customerConfig.size());
        //获取配置属性 listenerName  相同的话只会以第一次创建，后面丢弃
        map=customerConfig.stream().collect(Collectors.toMap(CustomerProperties::getListenerName,a->a,(n1,n2)->n1));
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        event.getApplicationContext().getBeansWithAnnotation(Component.class).forEach((beanName, bean) -> {
//            Class<?> beanClass = bean.getClass();
            // 获取真正的目标类
            Class<?> beanClass =  AopProxyUtils.ultimateTargetClass(bean);
            Method[] methods = beanClass.getDeclaredMethods();
            for (Method method : methods) {
                // AnnotationUtils.findAnnotation() 方法会比 isAnnotationPresent() 更强大，能够处理代理和继承等复杂情况。
                // if (hasAnnotation(method, RocketMqListener.class)) {
                if (AnnotationUtils.findAnnotation(method, RocketMqListener.class) != null) {

                    RocketMqListener listener = method.getAnnotation(RocketMqListener.class);
                    CustomerProperties customerProperties= map.get(listener.value());

                    if (customerProperties==null){
                        log.warn("未配置消费者："+listener.value());
                        continue;
                    }else{
                        log.info("配置消费者："+listener.value());
                    }

                    try {
                        // 设置可访问私有方法
                        method.setAccessible(true);
                        // 验证方法参数类型
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 0){
                            throw new RuntimeException(beanClass+"  "+method.getName()+ "Method does not accept a RocketMessage parameter");
                        }

                        if (parameterTypes.length == 1 && RocketMessage.class.isAssignableFrom(parameterTypes[0])) {
                            MethodWithBean methodWithBean=new MethodWithBean(method, bean);
                            String tag= StringUtils.isNotBlank(customerProperties.getTag())?customerProperties.getTag():"*";
                            //顺序消费
                            if (Objects.requireNonNull(customerProperties.getListenerType()) == MessageListenerEnum.ORDERLY) {
                                new ConsumerOrderly(rocketMqProperties.getNameServer(), customerProperties.getTopic(), "*", customerProperties.getGroup(), methodWithBean);
                            } else {
                                new ConsumerConcurrently(rocketMqProperties.getNameServer(), customerProperties.getTopic(), tag, customerProperties.getGroup(), methodWithBean);
                            }
                        } else {
                            //不接收的异常 参数
                            throw new IllegalArgumentException(beanClass+"  "+method.getName()+" Method does not accept a RocketMessage parameter");
                        }
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    /**
     * 判断方法是否有注解
     * @param method
     * @param annotationClass
     * @return
     */
    private boolean hasAnnotation(Method method, Class<? extends Annotation> annotationClass) {
        if (method.isAnnotationPresent(annotationClass)) {
            return true;
        }
        // 检查桥接方法
        Method bridgeMethod = BridgeMethodResolver.findBridgedMethod(method);
        return bridgeMethod.isAnnotationPresent(annotationClass);
    }

    /**
     *  Transactional 注解是通过代理机制实现的，导致实际的方法签名与预期不同
     * @param bean
     * @return
     */
    private Class<?> getTargetClass(Object bean) {
        if (Proxy.isProxyClass(bean.getClass())) {
            return (Class<?>) Proxy.getInvocationHandler(bean).getClass().getSuperclass();
        } else {
            return bean.getClass();
        }
    }
}
