package com.ttbgz.aliyun.oss.service;

import com.aliyun.oss.model.PutObjectResult;

/**
 * @author ttbgz
 */
public interface IOssService {
    /**
     * 上传文件
     * @param bucketName 桶名称
     * @param fileName 文件名称
     * @param bytes 文件bytes
     * @return 上传结果
     */
    PutObjectResult uploadFile(String bucketName, String fileName, byte[] bytes);

}
