/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient;


import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiCode;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

/**
 * HttpClient 执行器
 */

public class HttpClientExecutor {


    private CloseableHttpClient httpClient;

    public HttpClientExecutor(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpEntity invoke(HttpClientRequest request) {
        if (request.getInvokeMethod() == ApiInvokeMethod.GET) {
            HttpGet get = new HttpGet(request.getUrl());
            return this.execute(get, request);
        }
        if (request.getInvokeMethod() == ApiInvokeMethod.POST) {
            HttpPost post = new HttpPost(request.getUrl());
            return this.execute(post, request);
        }
        if (request.getInvokeMethod() == ApiInvokeMethod.PUT) {
            HttpPut put = new HttpPut(request.getUrl());
            return this.execute(put, request);
        }
        if (request.getInvokeMethod() == ApiInvokeMethod.DELETE) {
            HttpDelete delete = new HttpDelete(request.getUrl());
            return this.execute(delete, request);
        }
        throw new ApiException(ApiCode.API_ERROR, "请求方式不能为空");
    }

    /**
     * Get 请求
     *
     * @param request
     * @return
     */
    public HttpEntity execute(HttpRequestBase http, HttpClientRequest request) {
        try {
            if (request.getHeaders() != null) {
                for (String key : request.getHeaders().keySet()) {
                    http.setHeader(key, request.getHeaders().get(key));
                }
            }
            CloseableHttpResponse response = httpClient.execute(http);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new ApiException(String.valueOf(statusCode), EntityUtils.toString(response.getEntity(), "utf-8"));
            }
            return response.getEntity();
        } catch (ApiException e) {
            throw e;
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {
                throw new ApiException("-504", e);
            } else if (e instanceof ConnectException) {
                throw new ApiException("-502", e);
            }
            throw new ApiException("-505", e);
        } catch (Exception e) {
            throw new ApiException("-505", e);
        }
    }

    public HttpEntity execute(HttpEntityEnclosingRequestBase http, HttpClientRequest request) {
        try {
            if (request.getHeaders() != null) {
                for (String key : request.getHeaders().keySet()) {
                    http.setHeader(key, request.getHeaders().get(key));
                }
            }
            if (ApiConstants.APPLICATION_FORM_URLENCODED_VALUE.equals(request.getContentType())) {
                http.setEntity(new UrlEncodedFormEntity(request.getNameValuePairs(), request.getCharset()));
            } else if (ApiConstants.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
                http.setEntity(new StringEntity(request.getJsonData(), Charset.forName(request.getCharset())));
            } else {
                MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntityBuilder.setCharset(Charset.forName(request.getCharset()));
                for (BasicNameValuePair b : request.getNameValuePairs()) {
                    multipartEntityBuilder.addPart(b.getName(), new StringBody(b.getValue(), ContentType.APPLICATION_JSON));
                }
                if (request.getFileMap() != null) {
                    for (String fileName : request.getFileMap().keySet()) {
                        multipartEntityBuilder.addPart(fileName, new FileBody(request.getFileMap().get(fileName)));
                    }
                }
                http.setEntity(multipartEntityBuilder.build());
            }
            CloseableHttpResponse response = httpClient.execute(http);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new ApiException(String.valueOf(statusCode), EntityUtils.toString(response.getEntity(), "utf-8"));
            }
            return response.getEntity();
        } catch (ApiException e) {
            throw e;
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {
                throw new ApiException("-504", e);
            } else if (e instanceof ConnectException) {
                throw new ApiException("-502", e);
            }
            throw new ApiException("-505", e);
        } catch (Exception e) {
            throw new ApiException("-505", e);
        }
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
