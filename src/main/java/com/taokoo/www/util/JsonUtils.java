package com.taokoo.www.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 * JSON 转换
 */
@Slf4j
public final class JsonUtils {

    /**
     * 把Java对象转换成json字符串
     *
     * @param object 待转化为JSON字符串的Java对象
     * @return json 串 or null
     */
    public static String parseObjToJson(Object object) {
        String string = null;
        try {
            //string = JSON.toJSONString(object);
            string = JSONObject.toJSONString(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return string;
    }

    /**
     * 将Json字符串信息转换成对应的Java对象
     *
     * @param json json字符串对象
     * @param c    对应的类型
     */
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void saveJson(String content, String fileName) {
        try {
            Files.write(Paths.get("src/main/resources/" + fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("JsonUtils.saveJson写文件错误", e);
        }
    }

    public static String readJsonFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/main/resources/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("JsonUtils.readJsonFile", e);
        }
        return null;
    }
}