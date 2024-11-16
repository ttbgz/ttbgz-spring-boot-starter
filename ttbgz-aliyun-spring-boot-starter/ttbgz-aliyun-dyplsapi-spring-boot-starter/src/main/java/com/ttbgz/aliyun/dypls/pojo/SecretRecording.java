package com.ttbgz.aliyun.dypls.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author ttbgz
 */
@Data
public class SecretRecording {
    /**
     * 对应的号池Key。
     */
    @JSONField(name = "pool_key")
    @JsonProperty("pool_key")
    private String poolKey;
    /**
     *
     * 绑定关系ID。
     */
    @JSONField(name = "subs_id")
    @JsonProperty("subs_id")
    private Long subsId;
    /**
     * 呼叫记录ID。说明 call_id长度限制在100个字符以内。
     */
    @JSONField(name = "call_id")
    @JsonProperty("call_id")
    private String callId;
    /**
     * 呼叫时间，时间戳格式。
     */
    @JSONField(name = "call_time")
    @JsonProperty("call_time")
    private LocalDateTime callTime;
    /**
     * 外部业务ID
     */
    @JSONField(name = "out_id")
    @JsonProperty("out_id")
    private String outId;

    public void setCallTime(String callTime) {
        if (callTime != null){
            //秒级
            if (callTime.length() == 10){
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(callTime)), ZoneId.systemDefault());
                this.callTime = zonedDateTime.toLocalDateTime();
            }
            //毫秒级
            if (callTime.length() == 13){
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(callTime)), ZoneId.systemDefault());
                this.callTime = zonedDateTime.toLocalDateTime();
            }

        }
    }

}
