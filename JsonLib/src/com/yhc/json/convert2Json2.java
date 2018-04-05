package com.yhc.json;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午7:05:52
 * @see Java转换成Json工具
 */
public class convert2Json2 {
	
	public static String convert2Json2(Object object) {
	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(java.util.Date.class,
	            new JsonValueProcessor() {
	                private final String format = "yyyy-MM-dd hh:mm:ss";
	 
	                public Object processArrayValue(Object object,
	                        JsonConfig jsonConfig) {
	                    return null;
	                }
	 
	                public Object processObjectValue(String string,
	                        Object object, JsonConfig jsonConfig) {
	                    if (null == object) {
	                        return "";
	                    } else {
	                        if (object instanceof java.util.Date) {
	                            SimpleDateFormat simpleDateFormat = new
	                                SimpleDateFormat(format);
	                            String dateStr = simpleDateFormat
	                                    .format(object);
	                            return dateStr;
	                        }
	                    }
	 
	                    return object.toString();
	                }
	            });
	 
	    if (object instanceof String)
	        return object.toString();
	    if ((object instanceof Object[]) || (object instanceof List)) {
	        JSONArray jsonObject = JSONArray.fromObject(object, jsonConfig);
	        return jsonObject.toString() + '\n';
	    } else {
	        JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
	        return jsonObject.toString() + '\n';
	    }
	}

}
