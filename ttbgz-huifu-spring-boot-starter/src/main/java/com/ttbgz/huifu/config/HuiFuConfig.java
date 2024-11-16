package com.ttbgz.huifu.config;

import com.alibaba.fastjson.JSON;
import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.config.MerConfig;
import com.ttbgz.huifu.properties.HuiFuProperties;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author ttbgz
 */
@Slf4j
@EnableConfigurationProperties(value = {HuiFuProperties.class})
public class HuiFuConfig implements CommandLineRunner {
    @Resource private HuiFuProperties huiFuProperties;

    @Override
    public void run(String... args) throws Exception {
        /*
         *  debug 模式，开启后有详细的日志
         */
        if (huiFuProperties.isDebug()){
            BasePay.debug = true;
        }
        /*
         * prodMode 模式，默认为生产模式
         * MODE_PROD = "prod"; // 生产环境
         * MODE_TEST = "test"; // 线上联调环境(针对商户联调测试)
         */
        BasePay.prodMode = BasePay.MODE_PROD;
        if (BasePay.MODE_PROD.equals(huiFuProperties.getProdMode())){
            BasePay.prodMode = BasePay.MODE_PROD;
        }else{
            BasePay.prodMode = huiFuProperties.getProdMode();
        }

        /*
         * 单商户模式
         */
        MerConfig merConfig = new MerConfig();
        merConfig.setProcutId(huiFuProperties.getProductId());
        merConfig.setSysId(huiFuProperties.getSysId());
        merConfig.setRsaPrivateKey(huiFuProperties.getRsaPrivateKey());
        merConfig.setRsaPublicKey(huiFuProperties.getRsaPublicKey());
        BasePay.initWithMerConfig(merConfig);
        log.info("初始化商户配置:{}", JSON.toJSONString(merConfig));
    }
}
