package com.ttbgz.huifu.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "huifu",ignoreInvalidFields = true)
public class HuiFuProperties {

    /**
     * 汇付分配的产品号
     */
   private String productId;
    /**
     * 汇付分配的系统号
     */
   private String sysId;
    /**
     * 商户进件后获得的商户号
     */
   private String huifuId;
    /**
     * 服务商私钥，用于调用接口时进行签名
     */
   private String rsaPrivateKey;
    /**
     * 汇付公钥，用于对汇付返回报文进行签名验证
     */
   private String rsaPublicKey;
    /**
     * 汇付id
     */
   private String upperHuifuId;
    /**
     * debug 模式，开启后有详细的日志
     */
   private boolean debug=false;
    /**
     *  prodMode 模式，默认为生产模式 prod 生产模式 test 测试模式
     */
   private String prodMode="prod";

}
