package com.ttbgz.websocke.utils;


import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static String toString(Object o) {
        try {
            return JSON.toJSONString(o);
        } catch (Exception e) {
            logger.error("Error writing json object: {}", e.getMessage());
        }
        return "";
    }

    public static <T> T fromString(String s, Class<T> cls) {

        try {
            return JSON.parseObject(s, cls);
        } catch (Exception e) {
            logger.error("Error parse string to json object: {}", e.getMessage());
        }

        return null;
    }

//    public static <T> T fromString(String s, TypeReference<T> typeReference) {
//
//        try {
//            return getMapper().readValue(s, typeReference);
//        } catch (Exception e) {
//            logger.error("Error parse string to json object: {}", e.getMessage());
//        }
//
//        return null;
//    }

//    private static ObjectMapper mapper;

//    public static ObjectMapper getMapper() {
//        if (mapper == null) {
//            mapper = new ObjectMapper();
//            mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        }
//        return mapper;
//    }

//    public static void configureDateFormatString() {
//        getMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        getMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//    }

//    public static void configureTimeZone(TimeZone timeZone) {
//        getMapper().setTimeZone(timeZone);
//    }

}
