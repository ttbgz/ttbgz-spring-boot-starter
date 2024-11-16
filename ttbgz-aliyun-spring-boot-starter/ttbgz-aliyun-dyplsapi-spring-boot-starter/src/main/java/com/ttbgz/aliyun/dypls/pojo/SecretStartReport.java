package com.ttbgz.aliyun.dypls.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 呼叫发起时立即获取到通话记录信息对象
 * @author ttbgz
 */
@Data
public class SecretStartReport implements Serializable {
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
     *唯一标识一通通话记录的ID。
     * 说明  call id长度限制在100个字符以内。
     */
    @JSONField(name = "call_id")
    @JsonProperty("call_id")
    private String callId;
    /**
     *A号码。
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
     * B号码、N号码或者G组号码。
     */
    @JSONField(name = "peer_no")
    @JsonProperty("peer_no")
    private String peerNo;
    /**
     * 被叫显号。
     */
    @JSONField(name = "called_display_no")
    @JsonProperty("called_display_no")
    private String calledDisplayNo;
    /**
     *呼叫类型。取值：
     * 0：主叫（phone_no打给peer_no。）
     * 1：被叫（peer_no打给phone_no）。
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
     * 外部业务ID。
     */
    @JSONField(name = "out_id")
    @JsonProperty("out_id")
    private String outId;
    /**
     *无绑定关系时返回NO_SUBS_EXIST。
     */
    @JSONField(name = "control_msg")
    @JsonProperty("control_msg")
    private String controlMsg;


}
