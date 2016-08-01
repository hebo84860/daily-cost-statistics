package com.yeapoo.statistics.util;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class JsonUtil {   
  
    /**页面传至后台时，json数据在request的参数名称*/  
//    public final static String JSON_ATTRIBUTE = "json";
//    public final static String JSON_ATTRIBUTE1 = "json1";
//    public final static String JSON_ATTRIBUTE2 = "json2";
//    public final static String JSON_ATTRIBUTE3 = "json3";
//    public final static String JSON_ATTRIBUTE4 = "json4";

    /**
     * 把数据对象转换成json字符串
     * DTO对象形如：{"id" : idValue, "name" : nameValue, ...}
     * 数组对象形如：[{}, {}, {}, ...]
     * map对象形如：{key1 : {"id" : idValue, "name" : nameValue, ...}, key2 : {}, ...}
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getJSONString(Object object){
        String jsonString = null;
        //日期值处理器
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        if(object != null){
            if(object instanceof Collection || object instanceof Object[]){
                jsonString = JSONArray.fromObject(object, jsonConfig).toString();
            }else{
                jsonString = JSONObject.fromObject(object, jsonConfig).toString();
            }
        }
        return jsonString == null ? "{}" : jsonString;
    }

    /**
     * 从json HASH表达式中获取一个map，该map支持嵌套功能
     * 形如：{"id" : "johncon", "name" : "小强"}
     * 注意commons-collections版本，必须包含org.apache.commons.collections.map.MultiKeyMap
     * @param jsonString
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String,Object> getMapFromJson(String jsonString) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (jsonString!=null && !jsonString.equals("")) {
            setDataFormat2JAVA();
            JSONObject jsonObject = JSONObject.fromObject(jsonString);
            for(Iterator<String> iter = jsonObject.keys(); iter.hasNext();){
                String key = iter.next();
                map.put(key, jsonObject.get(key));
            }
        }
        return map;
    }

    private static void setDataFormat2JAVA(){
        //设定日期转换格式
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
    }

    public static class JsonDateValueProcessor implements JsonValueProcessor {

        private String format = "yyyy-MM-dd HH:mm:ss";

        public JsonDateValueProcessor() {

        }

        public JsonDateValueProcessor(String format) {
            this.format = format;
        }

        public Object processArrayValue(Object value, JsonConfig jsonConfig) {
            return process(value, jsonConfig);
        }

        public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
            return process(value, jsonConfig);
        }

        private Object process( Object value, JsonConfig jsonConfig ) {
            if (value instanceof Date) {
                String str = new SimpleDateFormat(format).format((Date) value);
                return str;
            }
            return value == null ? null : value.toString();
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

    }
}  
