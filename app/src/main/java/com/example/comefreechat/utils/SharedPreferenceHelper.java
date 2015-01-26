
package com.example.comefreechat.utils;

import java.util.Iterator;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 类名: SharedPreferenceHelper <br/> 
 * 功能: SharedPreference帮助类. <br/> 
 * 创建日期: 2014-9-16 上午9:22:55 <br/> 
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.6
 * @see       
 *
 */
@SuppressWarnings({"rawtypes"})
public class SharedPreferenceHelper {

	/**
	 * getParams:根据SharedPreference文件名称获取文件里的内容. <br/> 
	 * @author wchhuangya
	 * @param context	-	上下文
	 * @param fileName	-	文件名称
	 * @return			-	Map格式的键值对
	 */
	public static Map getParams(Context context, String fileName) {
		SharedPreferences settings = context.getSharedPreferences(
				fileName, 0);
		return settings.getAll();
	}
	/**
	 * removeParams:根据文件名称和key值删除SharedPreference文件里的某个键值对. <br/> 
	 * @author wchhuangya
	 * @param context	-	上下文
	 * @param fileName	-	文件名称
	 * @param key		-	要删除的键
	 * @return			-	是否删除成功
	 */
	public static boolean removeParams(Context context, String fileName, String key) {
		boolean res = false;
		try {
			if (key != null && !"".equals(key)) {
				SharedPreferences settings = context.getSharedPreferences(
						fileName, 0);
				SharedPreferences.Editor edit = settings.edit();
				edit.remove(key);
				edit.commit();
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * saveParams:把键值对保存到相应的SharedPreference文件中. <br/> 
	 * @author wchhuangya
	 * @param context	-	上下文
	 * @param fileName	-	文件名称
	 * @param map		-	要保存的键值
	 * @return			-	是否保存成功
	 */
	public static boolean saveParams(Context context, String fileName, Map map) {
		boolean res = false;
		try {
			if (map != null && !map.isEmpty()) {
				SharedPreferences settings = context.getSharedPreferences(
						fileName, 0);
				SharedPreferences.Editor edit = settings.edit();
				for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
					Map.Entry e = (Map.Entry) it.next();
					edit.putString(e.getKey().toString(), e.getValue().toString());
				}
				edit.commit();
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
