package com.ttbgz.aliyun.oss.entity;

import com.aliyun.oss.model.ObjectMetadata;
import lombok.Data;

import java.io.InputStream;
@Data
public class OSSFileObject {
    // Object key (name)
    private String key;

    // Object's bucket name
    private String bucketName;

    // Object's metadata.
    private ObjectMetadata metadata = new ObjectMetadata();

    // Object's content
    private String objectContent;

    public  OSSFileObject(){}
    public OSSFileObject(String key, String bucketName, ObjectMetadata metadata,String objectContent){
        this.key = key;
        this.bucketName = bucketName;
        this.metadata = metadata;
        this.objectContent = objectContent;
    }
}
