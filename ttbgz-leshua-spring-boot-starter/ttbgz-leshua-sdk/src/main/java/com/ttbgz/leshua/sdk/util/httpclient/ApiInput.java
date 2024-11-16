package com.ttbgz.leshua.sdk.util.httpclient;

import com.alibaba.fastjson.annotation.JSONField;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

import java.io.File;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * api输入参数基类
 */
public abstract class ApiInput implements Serializable {

    private static final long serialVersionUID = 3277652365580590205L;
    @JSONField(serialize = false)
    private String url;
    @JSONField(serialize = false)
    private String charset;

    /**
     * 请求方式
     *
     * @return
     */
    @JSONField(serialize = false)
    private String contentType;

    /**
     * 接口调用方式
     *
     * @return
     */
    @JSONField(serialize = false)
    private ApiInvokeMethod method;

    /**
     * 设置超时时间
     **/
    @JSONField(serialize = false)
    private Integer timeOut = 5 * 1000;
    /**
     * 访问是否熔断
     **/
    @JSONField(serialize = false)
    private boolean fuse;
    /**
     * 请求头
     */
    @JSONField(serialize = false)
    private Map<String, String> headers = new ConcurrentHashMap<String, String>();
    /**
     * RESTFUL参数
     **/
    @JSONField(serialize = false)
    private Map<String, String> restful = new ConcurrentHashMap<String, String>();
    /**
     * 请求参数
     **/
    @JSONField(serialize = false)
    private Map<String, String> parameters = new ConcurrentHashMap<String, String>();

    @JSONField(serialize = false)
    private Map<String, File> fileMap;

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isFuse() {
        return fuse;
    }

    public void setFuse(boolean fuse) {
        this.fuse = fuse;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public Map<String, String> getRestful() {
        return restful;
    }

    public ApiInput setRestful(String key, String value) {
        this.restful.put(key, value);
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRestful(Map<String, String> restful) {
        this.restful = restful;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * 添加URL拼接参数
     *
     * @param key
     * @param value
     * @return
     */
    public ApiInput addParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ApiInvokeMethod getMethod() {
        return method;
    }

    public void setMethod(ApiInvokeMethod method) {
        this.method = method;
    }


    public Map<String, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }
}
