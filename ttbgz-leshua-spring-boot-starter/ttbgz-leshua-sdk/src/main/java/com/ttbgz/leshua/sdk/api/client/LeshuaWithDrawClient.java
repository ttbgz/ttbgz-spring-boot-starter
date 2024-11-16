package com.ttbgz.leshua.sdk.api.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ttbgz.leshua.sdk.api.config.LeshuaConfig;
import com.ttbgz.leshua.sdk.api.request.LeshuaWithDrawRequest;
import com.ttbgz.leshua.sdk.api.response.LeshuaWithDrawResponse;
import com.ttbgz.leshua.sdk.remote.WithDrawInput;
import com.ttbgz.leshua.sdk.util.SignUtils;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInvokeSupport;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;

/**
 * @author Claire
 * @date 2022/8/27 16:18
 * @description
 */
public class LeshuaWithDrawClient<T> extends LeshuaBasicClient<T, LeshuaWithDrawResponse<T>, LeshuaWithDrawRequest<T>> {

    public LeshuaWithDrawClient(LeshuaConfig leshuaConfig) {
        super(leshuaConfig);
    }

    @Override
    public LeshuaWithDrawResponse<T> execute(LeshuaWithDrawRequest<T> request) {
        return super.execute(request);
    }

    @Override
    public LeshuaWithDrawResponse<T> execute(LeshuaConfig leshuaConfig, LeshuaWithDrawRequest<T> request) {
        return super.execute(leshuaConfig, request);
    }

    @Override
    protected ApiInput getApiInput(LeshuaConfig leshuaConfig, LeshuaWithDrawRequest<T> request) {
        String agentId = leshuaConfig.getAgentId();
        String key = leshuaConfig.getKey();
        String charset = leshuaConfig.getCharset();
        JSONObject data = request.getData();
        String apiMethodName = request.getApiMethodName();
        WithDrawInput input = new WithDrawInput();
        input.setAgentId(agentId);
        input.setData(data);
        input.setSign(SignUtils.getSign(key, charset, data, request.getReqSerialNo(), leshuaConfig.getVersion()));
        input.setReqSerialNo(request.getReqSerialNo());
        input.setVersion(leshuaConfig.getVersion());
        input.setUrl(leshuaConfig.getServerUrl() + apiMethodName);
        input.setTimeOut(leshuaConfig.getReadTimeout());
        return input;
    }

    @Override
    protected LeshuaWithDrawResponse<T> parseResponse(String responseStr) {
        return ApiInvokeSupport.json2Object(responseStr, new TypeReference<LeshuaWithDrawResponse<T>>(){});
    }
    @Override
    protected LeshuaWithDrawResponse<T> parseResponseFromEx(ApiException e) {
        return new LeshuaWithDrawResponse("-1","网络异常[" + e.getCode() + "]，请检查网络和配置参数，或联系运营人员");
    }

}
