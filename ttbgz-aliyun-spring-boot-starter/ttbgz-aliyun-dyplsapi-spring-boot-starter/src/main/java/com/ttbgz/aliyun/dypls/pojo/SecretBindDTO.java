package com.ttbgz.aliyun.dypls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ttbgz
 */
@Data
@NoArgsConstructor
public class SecretBindDTO {
    /**
     * 分机号码。 说明 接口 BindAxb 不涉及分机号码，请忽略该返回参数。
     */
    public String extension;
    /**
     * 隐私号码，即 X 号码。
     */
    public String secretNo;
    /**
     * 绑定关系 ID。
     */
    public String subsId;

    public SecretBindDTO(String extension,String secretNo,String subsId){
        this.extension=extension;
        this.secretNo=secretNo;
        this.subsId=subsId;
    }
}
