package com.ttbgz.huaweicloud.ivs.service.impl;

import com.alibaba.fastjson2.JSON;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ivs.v2.IvsClient;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.ivs.v2.model.*;
import com.huaweicloud.sdk.ivs.v2.region.IvsRegion;
import com.ttbgz.huaweicloud.ivs.properties.HuaweiIvsProperties;
import com.ttbgz.huaweicloud.ivs.service.HuaweiIvsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ttbgz
 */
@Service
@Slf4j
public class HuaweiIvsServiceImpl implements HuaweiIvsService {

    @Autowired private HuaweiIvsProperties huaweiIvsProperties;

    /**
     * https://ivs.cn-north-1.myhuaweicloud.com/v2.0/ivs-idcard-extention
     * @return
     */
    @Override
    public boolean ivsIdCardExtention(String userName,String idCard){

        ICredential auth = new BasicCredentials()
                .withAk(huaweiIvsProperties.getHuaweiCloudProperties().getAppKey())
                .withSk(huaweiIvsProperties.getHuaweiCloudProperties().getAppSecret());

        IvsClient client = IvsClient.newBuilder()
                .withCredential(auth)
                .withRegion(IvsRegion.valueOf(huaweiIvsProperties.getRegion()))
                .build();
        DetectExtentionByNameAndIdRequest request = new DetectExtentionByNameAndIdRequest();
        IvsExtentionByNameAndIdRequestBody body = new IvsExtentionByNameAndIdRequestBody();
        List<ExtentionReqDataByNameAndId> listDataReqData = new ArrayList<>();
        listDataReqData.add(
                new ExtentionReqDataByNameAndId()
                        .withVerificationName(userName)
                        .withVerificationId(idCard)
        );
        IvsExtentionByNameAndIdRequestBodyData databody = new IvsExtentionByNameAndIdRequestBodyData();
        databody.withReqData(listDataReqData);
        Meta metabody = new Meta();
        metabody.withUuid(UUID.randomUUID().toString());
        body.withData(databody);
        body.withMeta(metabody);
        request.withBody(body);
        try {
            DetectExtentionByNameAndIdResponse response = client.detectExtentionByNameAndId(request);
            log.info("华为云认证：{}", JSON.toJSONString(response));
            IvsExtentionByNameAndIdResponseBodyResult ivsExtentionByNameAndIdResponseBodyResult=response.getResult();
            List<ExtentionRespDataByNameAndId> list=ivsExtentionByNameAndIdResponseBodyResult.getRespData();
            return list.size()>0;
        } catch (ConnectionException e) {
            e.printStackTrace();
            throw new RuntimeException("华为云ivs连接异常");
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException("华为云ivs请求超时");
        } catch (ServiceResponseException e) {
                log.info("华为云ivs请求异常:",e);
            throw new RuntimeException("认证失败!");
        }
    }
}
