package com.example.comefreechat.utils;

/**
 * <p>
 * 日志帮助类
 * 获取android日志tag名称
 * </p>
 * 
 * @company 中国电信甘肃万维公司
 * 
 * @project nma-c-android
 * 
 * @version V2.0.0
 * 
 * @author
 * 
 * @date 2012-7-30 下午4:20:49
 * 
 * @class com.gsww.util.LogHelper
 * 
 */
public class LogUtils {

	@SuppressWarnings("rawtypes")
	public static String makeLogTag(Class cls) {
		return Constants.SYS_TAG+"_" + cls.getSimpleName();
	}

}
