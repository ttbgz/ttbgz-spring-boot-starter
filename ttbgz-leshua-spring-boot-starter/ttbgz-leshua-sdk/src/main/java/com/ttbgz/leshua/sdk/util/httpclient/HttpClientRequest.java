/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient;


import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 接口请求相关信息
 */

public class HttpClientRequest {

    private String url;

    private String charset;

    private ApiInvokeMethod invokeMethod;

    private Map<String, String> headers;

    /**
     * 表单数据，对应 application/x-www-form-urlencoded 提交方式
     */
    private List<BasicNameValuePair> nameValuePairs;

    /**
     * JSON数据，对应 application/json 提交方式
     */
    private String jsonData;
    private Map<String, File> fileMap;

    private Integer timeout;

    private String contentType = ApiConstants.APPLICATION_JSON_VALUE;

    public HttpClientRequest(String url, ApiInvokeMethod invokeMethod) {
        this.url = url;
        this.invokeMethod = invokeMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public ApiInvokeMethod getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(ApiInvokeMethod invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public List<BasicNameValuePair> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(List<BasicNameValuePair> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }
}
