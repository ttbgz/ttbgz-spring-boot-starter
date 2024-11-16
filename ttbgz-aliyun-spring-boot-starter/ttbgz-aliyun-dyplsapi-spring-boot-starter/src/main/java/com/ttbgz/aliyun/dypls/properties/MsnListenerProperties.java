package com.ttbgz.aliyun.dypls.properties;

import lombok.Data;

/**
 * @author ttbgz
 */
@Data
public class MsnListenerProperties {
    /**
     * 消息类型 示例使用的回执消息类型为：SecretReport（呼叫结束后话单报告）。
     * 云通信产品下所有的回执消息类型:
     * 短信服务
     * 1:短信回执：SmsReport，
     * 2:短息上行：SmsUp
     * 3:国际短信回执：GlobeSmsReport
     *  ----------------------------------------------
     * 号码隐私保护服务
     * 1.呼叫发起时话单报告：SecretStartReport
     * 2.呼叫响铃时报告：SecretRingReport
     * 3.呼叫接听时报告：SecretPickUpReport
     * 4.呼叫结束后话单报告：SecretReport
     * 5.录音状态报告：SecretRecording
     * 6.录音ASR状态报告：SecretAsrReport
     * 7.短信内容报告：SecretSmsIntercept
     * 8.计费通话报告：SecretBillingCallReport
     * 9.计费短信报告：SecretBillingSmsReport
     * 10.异常号码状态推送：SecretExceptionPhoneReport
     * 11.放音录音状态报告：SecretRingRecording
     * 12.电商物流详情报告：SmartLogisticsReport
     * 13.号码管理信息：NumberManagementReport
     *  ----------------------------------------------
     * 语音服务
     * 1.呼叫记录消息：VoiceReport
     * 2.呼叫中间状态消息：VoiceCallReport
     * 3.录音记录消息：VoiceRecordReport
     * 4.实时ASR消息：VoiceRTASRReport
     * 5.融合通信呼叫记录消息：ArtcCdrReport
     * 6.融合通信呼叫中间状态：ArtcTempStatusReport
     */
    private String messageType;
    /**
     * 队列名称  示例使用的队列名称为：Alicom-Queue-10322476********-SecretReport。
     *  在阿里云通信消息接收打开轻量消息队列（原MNS）消费模式。接收消息队列信息
     */
    private String queueName;
}
