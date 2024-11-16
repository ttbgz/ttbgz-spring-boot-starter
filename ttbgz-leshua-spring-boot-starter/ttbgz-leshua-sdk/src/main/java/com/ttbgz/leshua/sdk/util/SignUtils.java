package com.ttbgz.leshua.sdk.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class SignUtils {

    private static Logger logger = LoggerFactory.getLogger(SignUtils.class);
    private static final Set<String> exludedSignParams=new HashSet<>();
    static {
        exludedSignParams.add("sign");
        exludedSignParams.add("error_code");
    }
    /**
     * 进件、分账key获取
     *
     * @param key
     * @param charset
     * @param data
     * @return
     */
    public static String getReisterSign(String key, String charset, JSONObject data) {
        return getReisterSign(key, charset, JsonObjectToString(data));
    }

    public static String getReisterSign(String key, String charset, String data) {
        StringBuffer orginalStr = new StringBuffer("lepos").append(key).append(data);
        logger.info("orginalStr = {}", orginalStr);
        try {
            String md5 = DigestUtils.md5Hex(orginalStr.toString().getBytes(charset));
            String sign = Base64.encodeBase64String(md5.getBytes(charset));
            logger.info("sign = {}", sign);
            return sign;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("122");
        }
    }
    public static boolean checkReisterSign(String key,String data,String sign)
    {
        if (getReisterSign(key, "utf-8", data).trim().equals(sign.trim())) {
            return true;
        }
        return false;
    }

    public static boolean checkTradeSign(String key,Map<String,Object> data,String sign)
    {
        JSONObject jsonObject = new JSONObject();
        for (String k: data.keySet()){
            if (data.get(k)!=null && !exludedSignParams.contains(k)) {
                jsonObject.put(k,data.get(k));
            }
        }
        return getSign(key, "utf-8", jsonObject).trim().equals(sign);
    }

    public static void buildPayParams(StringBuilder sb, Map<String, String> payParams, boolean encoding) {
        List<String> keys = new ArrayList<String>(payParams.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            sb.append(key).append("=");
            if (encoding) {
                sb.append(urlEncode(payParams.get(key)));
            } else {
                sb.append(payParams.get(key));
            }
            sb.append("&");
        }
        sb.setLength(sb.length() - 1);
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            return str;
        }
    }


    public static String getSign(String key, String charset,
                                 JSONObject data, String reqSerialNo,
                                 String version) {
        String sign = null;

        StringBuilder sb = new StringBuilder();
        sb.append(key).append(reqSerialNo)
                .append(version).append(JsonObjectToString(data));
        logger.info("all param:{}", sb);
        try {
            sign = DigestUtils.md5Hex(sb.toString().getBytes(charset));
            logger.info("sign: {}", sign);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }

    public static String JsonObjectToString(JSONObject data) {
        // 将data中字段有序排列
        SortedMap<String, Object> sortedMap = new TreeMap<>(data);
        return JSON.toJSONString(sortedMap);
    }

    public static String getSign(String key, String charset, JSONObject data) {
        // agent 使用
        String sign = null;
        SortedMap<String, Object> sortedMap = new TreeMap<>(data);
        StringBuilder sbuffer = new StringBuilder();
        for (String one : sortedMap.keySet()) {
            Object o = sortedMap.get(one);
            if (o == null) {
                continue;
            }
            sbuffer.append(one).append("=").append(o).append("&");
        }
        sbuffer.setLength(sbuffer.length() - 1);
        String paramStr = sbuffer.append("&key=").append(key).toString();
        logger.info("paramStr: {}", paramStr);
        try {
            sign = DigestUtils.md5Hex(paramStr.getBytes(charset)).toLowerCase();
            logger.info("sign {}", sign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }

    public static String sha256SignMap(Map<String, ? extends Object> map){
        StringBuilder sb = new StringBuilder();
        SortedMap<String, Object> sortedMap = new TreeMap<>(map);
        for (String one : sortedMap.keySet()) {
            Object o = sortedMap.get(one);
            if (o == null) {
                continue;
            }
            sb.append(one).append("=").append(o).append("&");
        }
        sb.setLength(sb.length() - 1);
        logger.info("params: {}",sb);
        byte[] bytes = DigestUtils.sha256(sb.toString());
        String base64String = Base64.encodeBase64String(bytes);
        logger.info("sha256 sing: {}",base64String);
        return base64String;
    }

}
