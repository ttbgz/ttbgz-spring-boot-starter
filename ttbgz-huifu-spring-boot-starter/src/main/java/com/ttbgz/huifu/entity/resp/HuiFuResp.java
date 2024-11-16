package com.ttbgz.huifu.entity.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class HuiFuResp implements Serializable {
    @JSONField(name = "resp_code")
    private String respCode;
    @JSONField(name = "resp_desc")
    private String respDesc;

}
