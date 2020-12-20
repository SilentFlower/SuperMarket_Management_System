package Util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * @author SiletFlower
 * @date 2020/12/16 18:11:47
 * @description
 */
public class NewJsonUtil {
    private NewJsonUtil(){}
    private static ObjectMapper jacksonMapper;

    static {
        jacksonMapper = new ObjectMapper()
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)  //允许使用未带引号的字段名
                //.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)  //允许使用单引号
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                .configure(SerializationFeature.INDENT_OUTPUT, true) // 格式化使json更可读,生产环境建议注释
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public static String toString(Object o) {
        String s = null;
        if (o instanceof String) return (String) o;
        try {
            s = jacksonMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static byte[] toByte(Object o) {
        byte[] s = null;
        if (o instanceof Byte) return (byte[]) o;
        try {
            s = jacksonMapper.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static <T> T toBean(String source, Class<T> dest) {
        T t = null;
        try {
            t = jacksonMapper.readValue(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T toBean(byte[] source, Class<T> dest) {
        T t = null;
        try {
            t = jacksonMapper.readValue(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


}
