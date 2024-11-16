package com.ttbgz.leshua.sdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ttbgz.leshua.sdk.util.httpclient.ApiInvokeSupport;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XmlUtils {
    private static Logger logger = LoggerFactory.getLogger(XmlUtils.class);

    public static <T> T xmlStr2Object(String result, TypeReference<T> type) {
        Map<String, Object> map = null;
        try {
            map = XmlUtils.xml2Map(result);
        } catch (IOException | JDOMException e) {
            logger.info("xml{}转换为map失败", result);
            e.printStackTrace();
        }
        logger.info("map: {}", map);
        if (map == null) {
            logger.error("返回结果异常");
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        JSONObject data1 = new JSONObject();
        for (String keyValue : map.keySet()) {
            if (!keyValue.equals("td_code") && (keyValue.endsWith("code") || keyValue.endsWith("msg"))) {
                jsonObject.put(keyValue, map.get(keyValue));
            } else {
                data1.put(keyValue, map.get(keyValue));
            }
        }
        jsonObject.put("data", data1);
        logger.info("jsonObject: {}", jsonObject);
        return ApiInvokeSupport.json2Object(JSON.toJSONString(jsonObject),type);
    }

    public static Map<String, Object> xml2Map(String xmlStr)
            throws IOException, JDOMException {
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new StringReader(xmlStr));
        // 得到根节点
        Element root = doc.getRootElement();
        String rootName = root.getName();
        rtnMap.put("root.name", rootName);
        // 调用递归函数，得到所有最底层元素的名称和值，加入map中
        convert(root, rtnMap, "");
        return rtnMap;
    }

    public static void convert(Element e, Map<String, Object> map,
                               String lastname) {
        String prename="";
        if (lastname != null && lastname!=""){
            prename=lastname+".";
        }
        if (e.getAttributes().size() > 0) {
            Iterator it_attr = e.getAttributes().iterator();
            while (it_attr.hasNext()) {
                Attribute attribute = (Attribute) it_attr.next();
                String attrname = attribute.getName();
                String attrvalue = e.getAttributeValue(attrname);
                map.put(prename+attrname, attrvalue);
            }
        }
        List children = e.getChildren();
        Iterator it = children.iterator();
        while (it.hasNext()) {
            Element child = (Element) it.next();
            String name = prename + child.getName();
            // 如果有子节点，则递归调用
            if (child.getChildren().size() > 0) {
                convert(child, map, name);
            } else {
                map.put(name, child.getText());
                // 如果该节点有属性，则把所有的属性值也加入map
                if (child.getAttributes().size() > 0) {
                    Iterator attr = child.getAttributes().iterator();
                    while (attr.hasNext()) {
                        Attribute attribute = (Attribute) attr.next();
                        String attrname = attribute.getName();
                        String attrvalue = child.getAttributeValue(attrname);
                        map.put(name + "." + attrname, attrvalue);
                    }
                }
            }
        }
    }

    public static String parseRequst(HttpServletRequest request){
        String body = "";
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(true){
                String info = br.readLine();
                if(info == null){
                    break;
                }
                if(body == null || "".equals(body)){
                    body = info;
                }else{
                    body += info;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static Map<String, Object> toMap(String xmlStr) throws Exception{
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new StringReader(xmlStr));
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        convert(doc.getRootElement(), rtnMap, "");
        return rtnMap;
    }
}
