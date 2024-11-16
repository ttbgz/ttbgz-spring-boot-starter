package com.ttbgz.aliyun.dypls.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 可以在呼叫结束后获取通话记录信息
 * @author ttbgz
 */
@Data
public class SecretReport {
    /**
     * 对应的号池Key。
     */
    @JSONField(name = "pool_key")
    @JsonProperty("pool_key")
    private String poolKey;
    /**
     * 绑定关系ID。
     */
    @JSONField(name = "sub_id")
    @JsonProperty("sub_id")
    private Long subId;
    /**
     * 录音下载URL。 说明录音下载URL的有效期是7天。
     */
    @JSONField(name = "record_url")
    @JsonProperty("record_url")
    private String recordUrl;
    /**
     * 放音录音URL。说明 放音录音URL的有效期是7天。
     */
    @JSONField(name = "ring_record_url")
    @JsonProperty("ring_record_url")
    private String ringRecordUrl;
    /**
     *通话记录ID。 说明
     * call_id长度限制在100个字符以内。
     */
    @JSONField(name = "call_id")
    @JsonProperty("call_id")
    private String callId;
    /**
     * A号码。
     */
    @JSONField(name = "phone_no")
    @JsonProperty("phone_no")
    private String phoneNo;
    /**
     * X号码。
     */
    @JSONField(name = "secret_no")
    @JsonProperty("secret_no")
    private String secretNo;
    /**
     * B号码、N号码或G组号码。
     */
    @JSONField(name = "peer_no")
    @JsonProperty("peer_no")
    private String peerNo;
    /**
     *被叫显号。
     */
    @JSONField(name = "called_display_no")
    @JsonProperty("called_display_no")
    private String calledDisplayNo;
    /**
     *呼叫类型。取值：
     * 0：主叫，即phone_no打给peer_no。
     * 1：被叫，即peer_no打给phone_no。
     * 4：呼叫拦截。
     */
    @JSONField(name = "call_type")
    @JsonProperty("call_type")
    private Integer callType;
    /**
     *主叫拨打时间。
     */
    @JSONField(name = "call_time")
    @JsonProperty("call_time")
    private LocalDateTime callTime;
    /**
     *被叫接听时间（通话计费开始时间）。如未接通，则等于release_time的时间。短信话单时，此值传短信接收时间。
     */
    @JSONField(name = "start_time")
    @JsonProperty("start_time")
    private LocalDateTime startTime;
    /**
     *  呼叫被叫侧发起的时间。如未发起，则等于call_time的时间；短信话单时，此值传短信接收时间。
     */
    @JSONField(name = "call_out_time")
    @JsonProperty("call_out_time")
    private LocalDateTime callOutTime;
    /**
     *
     * 被叫响铃时间。如果没有响铃时间，则等于call_out_time的时间。短信话单时，此值传短信接收时间。
     */
    @JSONField(name = "ring_time")
    @JsonProperty("ring_time")
    private LocalDateTime ringTime;
    /**
     * 被叫空闲振铃时间。
     * free_ring_time大于call_out_time表示被叫真实发生了振铃事件。
     * free_ring_time和call_out_time相等表示未振铃。
     * 如获取不到，则等于ring_time的时间。
     */
    @JSONField(name = "free_ring_time")
    @JsonProperty("free_ring_time")
    private LocalDateTime freeRingTime;
    /**
     *通话释放时间（通话计费结束时间）；短信话单时，此值传短信接收时间。
     * 说明
     * release_time和start_time之差表示通话时长， 如果结果为0，说明呼叫未接通。
     */
    @JSONField(name = "release_time")
    @JsonProperty("release_time")
    private LocalDateTime releaseTime;
    /**
     *短信长度。
     */
    @JSONField(name = "sms_number")
    @JsonProperty("sms_number")
    private Integer smsNumber;
    /**
     *通话释放方向。 取值：
     * 0：平台释放。
     * 1：主叫挂断。
     * 2：被叫挂断。
     */
    @JSONField(name = "release_dir")
    @JsonProperty("release_dir")
    private Integer releaseDir;
    /**
     *
     * 外部业务ID。
     */
    @JSONField(name = "out_id")
    @JsonProperty("out_id")
    private String outId;
    /**
     *未接通通话的原因归类。取值：
     * 0：正常通话。
     * 1：黑名单拦截。
     * 2：无绑定关系。
     * 3：呼叫限制。
     * 4：其他。
     */
    @JSONField(name = "unconnected_cause")
    @JsonProperty("unconnected_cause")
    private Integer unconnectedCause;
    /**
     *释放原因。更多详情，请参见话单错误码。
     * <a href="https://help.aliyun.com/zh/pnp/developer-reference/error-codes-of-call-records?spm=a2c4g.11186623.0.0.30575f65Pv70Rx">...</a>
     */
    @JSONField(name = "release_cause")
    @JsonProperty("release_cause")
    private Integer releaseCause;
    /**
     *无绑定关系时返回NO_SUBS_EXIST。
     */
    @JSONField(name = "control_msg")
    @JsonProperty("control_msg")
    private String controlMsg;
    /**
     *
     * 分机号。
     */
    @JSONField(name = "extension")
    @JsonProperty("extension")
    private String extension;

}
