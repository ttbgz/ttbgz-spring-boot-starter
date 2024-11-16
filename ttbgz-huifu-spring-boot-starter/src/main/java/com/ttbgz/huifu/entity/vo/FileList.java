package com.ttbgz.huifu.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 附件资料列表
 * @author ttbgz
 */
@Data
public class FileList implements Serializable {

    /**
     * 	文件类型
     * 	Y	8	请参考：文件类型枚举；示例值：F85
     */
    @JSONField(name = "file_type")
    private String fileType;
    /**
     * 文件jfileID
     * String	Y	128	图片上传接口生成的fileId；示例值：57cc7f00-600a-33ab-b614-6221bbf2e529
     */
    @JSONField(name = "file_id")
    private String fileId;
    /**
     * 文件名称
     * N	128	示例值：test42001.jpg
     */
    @JSONField(name = "file_name")
    private String fileName;

}
