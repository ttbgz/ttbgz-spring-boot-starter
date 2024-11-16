/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiCode;
import com.ttbgz.leshua.sdk.util.httpclient.exception.ApiException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接口调用辅助类
 */
public class ApiInvokeSupport {
    private static Logger logger = LoggerFactory.getLogger(ApiInvokeSupport.class);
    private static final HttpClientExecutor executor = new HttpClientExecutor(HttpClients.createDefault());

    /**
     * 接口调用
     *
     * @param input 输入参数
     * @return
     * @throws ApiException
     */
    public static String getStringResponse(ApiInput input) {
        HttpEntity entity = null;
        String url = null;
        try {
            HttpClientRequest request = checkAndInit(input);
            url = request.getUrl();
            logger.info(String.format("外部接口请求：%s, 入参：%s", url, JSON.toJSONString(input)));
            entity = executor.invoke(request);
            String result = convertEntityToString(entity, request.getCharset());
            logger.info(String.format("外部接口请求：%s，出参：%s", url, result));
            return result;
        } catch (ApiException e) {
            logger.error("第三方调用异常", e);
            throw e;
        } catch (Exception e) {
            logger.error("第三方调用异常", e);
            throw new ApiException(ApiCode.API_ERROR, e);
        } finally {
            // 释放连接
            if (entity != null) {
                EntityUtils.consumeQuietly(entity);
            }
        }
    }


    /**
     * 接口调用
     *
     * @param input 输入参数
     * @param clazz 返回值类型
     * @return
     * @throws ApiException
     */
    public static <T> T getObject(ApiInput input, Class<T> clazz) {
        String result = getStringResponse(input);
        return json2Object(result, clazz);
    }


    /**
     * 接口调用
     *
     * @param input 输入参数
     * @param clazz 返回值类型
     * @return
     * @throws ApiException
     */
    public static <T> List<T> getArray(ApiInput input, Class<T> clazz) {
        String result = getStringResponse(input);
        return json2Array(result, clazz);
    }

    /**
     * 接口调用
     *
     * @param input 输入参数
     * @return
     * @throws ApiException
     */
    public static byte[] getStreamByte(ApiInput input) {
        HttpEntity entity = null;
        String url = null;
        String code = "200";
        long start = System.currentTimeMillis();
        try {
            HttpClientRequest request = checkAndInit(input);
            url = request.getUrl();
            logger.info(String.format("外部接口请求：%s, 入参：%s", url, JSON.toJSONString(input)));
            entity = executor.invoke(request);
            return EntityUtils.toByteArray(entity);
        } catch (ApiException e) {
            logger.error("第三方调用异常", e);
            code = e.getCode();
            throw e;
        } catch (Exception e) {
            logger.error("第三方调用异常", e);
            code = ApiCode.API_ERROR;
            throw new ApiException(ApiCode.API_ERROR, e);
        } finally {
            if (entity != null) {
                EntityUtils.consumeQuietly(entity);// 释放连接
            }
        }
    }

    public static <T> T json2Object(String jsonData, Class<T> clazz) {
        if (StringUtils.isBlank(jsonData)) {
            return null;
        }
        if (String.class == clazz) {
            return (T) jsonData;
        }
        return JSON.parseObject(jsonData, clazz);
    }

    public static <T> T json2Object(String jsonData, TypeReference<T> type) {
        if (StringUtils.isBlank(jsonData)) {
            return null;
        }
        return JSON.parseObject(jsonData, type);
    }

    public static <T> List<T> json2Array(String jsonData, Class<T> clazz) {
        if (StringUtils.isBlank(jsonData)) {
            return null;
        }
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 校验
     *
     * @param input
     * @return
     */
    private static HttpClientRequest checkAndInit(ApiInput input) {
        if (input.isFuse()) {
            throw new ApiException(ApiCode.API_STOP_REQUEST, "访问已被阻止");
        }
        API api = input.getClass().getAnnotation(API.class);
        if (api == null) {
            throw new ApiException(ApiCode.API_ANNOTATION_NOT_EXIST, String.format("%s未使用@API注解标记", input.getClass().getName()));
        }
        // 接口地址校验
        String url = StringUtils.isEmpty(input.getUrl()) ? convert(api.url(), input.getRestful()) : input.getUrl();
        // 拼接地址后面的参数
        url = buildUrl(url, input.getParameters());
        ApiInvokeMethod invokeMethod = input.getMethod() == null ? api.method() : input.getMethod();
        if (invokeMethod == null) {
            throw new ApiException(ApiCode.API_METHOD_NOT_EXIST, String.format("%s未配置接口调用方式", input.getClass().getName()));
        }
        HttpClientRequest request = new HttpClientRequest(url, invokeMethod);
        String contentType = StringUtils.isEmpty(input.getContentType()) ? api.contentType() : input.getContentType();
        request.setContentType(contentType);
        if (ApiConstants.APPLICATION_FORM_URLENCODED_VALUE.equals(contentType) || ApiConstants.MULTIPART_FORM_DATA.equals(contentType)) {
            Map<String, String> dataMap = JSON.parseObject(JSON.toJSONString(input), new TypeReference<Map<String, String>>() {
            });
            List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
            for (String key : dataMap.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, dataMap.get(key)));
            }
            request.setNameValuePairs(nameValuePairs);
        } else {
            request.setJsonData(JSON.toJSONString(input));
        }
        if (input.getFileMap() == null) {
            input.getHeaders().put("Content-type", contentType);
        }
        request.setHeaders(input.getHeaders());
        request.setCharset(StringUtils.isEmpty(input.getCharset()) ? api.charset() : input.getCharset());
        request.setTimeout(input.getTimeOut());
        request.setFileMap(input.getFileMap());
        request.setContentType(contentType);
        return request;
    }


    /**
     * 组装请求地址
     *
     * @param url
     * @param parameters
     */
    private static String buildUrl(String url, Map<String, String> parameters) {
        if (parameters.size() != 0) {
            if (url.indexOf("?") != -1) {
                url = String.format("%s&%s", url, buildParameters(parameters));
            } else {
                url = String.format("%s?%s", url, buildParameters(parameters));
            }
        }
        return url;
    }

    /**
     * 拼接参数
     *
     * @param parameters
     * @return
     */
    public static String buildParameters(Map<String, String> parameters) {
        List<String> list = new ArrayList<String>(parameters.keySet());
        // 排序
        Collections.sort(list);
        StringBuffer buffer = new StringBuffer();
        for (String key : list) {
            buffer.append("&");
            buffer.append(String.format("%s=%s", key, parameters.get(key)));
        }
        return buffer.toString().substring(1);
    }

    public static final String PATTERN = "(?<=(?<!\\\\)\\{)(.*?)(?=(?<!\\\\)\\})";

    /**
     * 占位符转换
     *
     * @param url
     * @param restful
     * @return
     */
    private static String convert(String url, Map<String, String> restful) {
        // 查找符合 {} 的字符串
        Matcher matcher = Pattern.compile(PATTERN).matcher(url);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        if (list == null || list.size() == 0) {
            return url;
        }
        String finalUrl = url;
        for (String placeholder : list) {
            if (StringUtils.isEmpty(placeholder)) {
                throw new ApiException(ApiCode.API_PLACEHOLDER_INVALID, String.format("接口地址%s占位符错误", url));
            }
            String value = "";
            if (restful.containsKey(placeholder)) {
                value = restful.get(placeholder);
            }
            finalUrl = finalUrl.replace("{" + placeholder + "}", value);
        }
        return finalUrl;
    }

    private static String convertEntityToString(HttpEntity entity, String charset) throws IOException {
        String type = ContentType.getOrDefault(entity).getMimeType();
        // ContentType为如下类型时，将响应内容作为字符串返回
        if (ContentType.APPLICATION_JSON.getMimeType().equalsIgnoreCase(type)
                || ContentType.APPLICATION_XML.getMimeType().equalsIgnoreCase(type)
                || ContentType.TEXT_HTML.getMimeType().equalsIgnoreCase(type)
                || ContentType.TEXT_PLAIN.getMimeType().equalsIgnoreCase(type)
                || ContentType.TEXT_XML.getMimeType().equalsIgnoreCase(type)) {
            return EntityUtils.toString(entity, charset);
        } else {
            throw new RuntimeException("不支持的响应类型");
        }
    }


}
