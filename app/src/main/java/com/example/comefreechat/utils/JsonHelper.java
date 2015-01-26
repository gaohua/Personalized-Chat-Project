package com.example.comefreechat.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;


/**
 * 类名: JsonHelper <br/> 
 * 功能: json助手类. <br/> 
 * 创建日期: 2014-9-16 下午8:28:34 <br/> 
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.6
 * @see       
 *
 */
@SuppressWarnings("rawtypes")
public class JsonHelper {
	/**
	 * 把List<Map>转化为json字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJsonMap(List<Map> list) {
		String s = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			s = mapper.writeValueAsString(list);
		} catch (Exception e) {
		}
		return s;
	}
	/**
	 * 把Map转化为json字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String mapToJson(Map<String, String> map) {
		String s = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			s = mapper.writeValueAsString(map);
		} catch (Exception e) {
		}
		return s;
	}
	/**
	 * 把json字符串转换为List<Map<String,String>>
	 * 
	 * @param json
	 * @return
	 */
	public static List<Map<String, String>> jsonToList(String json) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(json, List.class);
		} catch (Exception e) {
			//  handle exception
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 把List<Map<String,String>>转化为json字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJson(List<Map<String, String>> list) {
		String s = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			s = mapper.writeValueAsString(list);
		} catch (Exception e) {
			//  handle exception
		}
		return s;
	}
}
