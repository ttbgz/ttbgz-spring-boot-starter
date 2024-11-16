package com.ttbgz.aliyun.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import com.ttbgz.aliyun.oss.service.IOssService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

/**
 * @author ttbgz
 */
@Service
public class OssServiceImpl implements IOssService {

    @Resource
    OSS oss;

    @Override
    public PutObjectResult uploadFile(String bucketName, String fileName, byte[] bytes) {

        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, new ByteArrayInputStream(bytes));
        // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
//         ObjectMetadata metadata = new ObjectMetadata();
//         metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传字符串。
        PutObjectResult result = oss.putObject(putObjectRequest);
        return result;
    }

    /**
     * 文件下载
     */
//    @PostMapping("download")
//    public ResponseEntity<InputStreamResource> download(@RequestParam("fileName")  String fileName) {
//
//        OSSObject ossObject = null;
//        try {
//            ossObject = oss.getObject("private1299", fileName);
//            if (ossObject == null) {
//                return ResponseEntity.notFound().build();
//            }
//
//            InputStream inputStream = ossObject.getObjectContent();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType(ossObject.getObjectMetadata().getContentType()));
//            headers.setContentDispositionFormData("attachment", fileName);
//
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .contentLength(ossObject.getObjectMetadata().getContentLength())
//                    .body(new InputStreamResource(inputStream));
//        } catch (OSSException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    }
