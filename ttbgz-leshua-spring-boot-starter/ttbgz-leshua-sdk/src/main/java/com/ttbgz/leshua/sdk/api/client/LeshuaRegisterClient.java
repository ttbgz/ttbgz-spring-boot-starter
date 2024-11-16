package com.ttbgz.leshua.sdk.api.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ttbgz.leshua.sdk.api.config.LeshuaConfig;
import com.ttbgz.leshua.sdk.api.request.LeshuaRegisterRequest;
import com.ttbgz.leshua.sdk.api.response.LeshuaRegisterResponse;
import com.ttbgz.leshua.sdk.remote.RegisterInput;
import com.ttbgz.leshua.sdk.util.SignUtils;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInvokeSupport;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Claire
 * @date 2022/8/19 20:57
 * @description
 */
public class LeshuaRegisterClient<T> extends LeshuaBasicClient<T, LeshuaRegisterResponse<T>, LeshuaRegisterRequest<T>> {
    private static Logger logger = LoggerFactory.getLogger(LeshuaRegisterClient.class);

    public LeshuaRegisterClient(LeshuaConfig leshuaConfig) {
        super(leshuaConfig);
    }

    @Override
    public LeshuaRegisterResponse<T> execute(LeshuaRegisterRequest<T> request) {
        return super.execute(request);
    }



    @Override
    protected ApiInput getApiInput(LeshuaConfig leshuaConfig, LeshuaRegisterRequest request) {
        RegisterInput input = new RegisterInput();
        String agentId = leshuaConfig.getAgentId();
        String key = leshuaConfig.getKey();
        String charset = leshuaConfig.getCharset();
        JSONObject data = request.getData();
        String apiMethodName = request.getApiMethodName();
        input.setAgentId(agentId);
        input.setUrl(leshuaConfig.getServerUrl() + apiMethodName);
        input.setTimeOut(leshuaConfig.getReadTimeout());
        input.setReqSerialNo(request.getReqSerialNo());
        input.setVersion(leshuaConfig.getVersion());
        Map<String, File> fileMap = request.getFileMap();
        fillFileParams(fileMap, data, input);
        input.setFileMap(fileMap);
        String dataStr = data.toJSONString();
        input.setData(dataStr);
        input.setSign(SignUtils.getReisterSign(key, charset, dataStr));
        return input;
    }

    private void fillFileParams(Map<String, File> fileMap, JSONObject data, RegisterInput input) {
        if (fileMap != null && fileMap.get("media") != null) {
            input.setContentType(ApiConstants.MULTIPART_FORM_DATA);
            File file = fileMap.get("media");
            InputStream in = null;
            try {
                in = new FileInputStream(file);
                byte[] bytes = IOUtils.toByteArray(in);
                String fileMD5 = DigestUtils.md5Hex(bytes);
                data.put("fileMD5", fileMD5);
            } catch (IOException e) {
                logger.warn("文件处理异常！");
                throw new RuntimeException(e.getMessage());
            } finally {
                IOUtils.closeQuietly(in);
            }
        }
    }


    @Override
    protected LeshuaRegisterResponse<T> parseResponse(String responseStr) {
        return ApiInvokeSupport.json2Object(responseStr, new TypeReference<LeshuaRegisterResponse<T>>(){});
    }


    @Override
    protected LeshuaRegisterResponse<T> parseResponseFromEx(ApiException e) {
        return new LeshuaRegisterResponse<>("000001", "网络异常[" + e.getCode() + "]，请检查网络和配置参数，或联系运营人员");
    }


}
