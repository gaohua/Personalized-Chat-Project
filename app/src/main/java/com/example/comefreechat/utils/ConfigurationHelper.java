package com.example.comefreechat.utils;
 
import java.io.InputStream;
import java.util.Properties;

/**
 * 类名: Configuration <br/> 
 * 功能: 配置助手类. <br/> 
 * 创建时间: 2014-9-16 下午5:01:03 <br/> 
 * 
 * @author wchhuangya 
 * @version  
 * @since Jdk 1.6
 */
public class ConfigurationHelper {
    private static Properties defaultProperty;

    static {
        init();
    }

    static void init() {
        defaultProperty = new Properties();
        InputStream stream =
        	ConfigurationHelper.class.getResourceAsStream("/assets/config.properties");
		try {
			defaultProperty.load(stream);
		} catch (Exception e) {

		}
		defaultProperty.putAll(System.getProperties());
    }
    
    /**
	 * 取得配置文件的对象值
	 * @param propertyName :对象名称
	 * @return 对象值
	 */
	public static String getPropertyByStr(String propertyName) {
		return String.valueOf(ConfigurationHelper.defaultProperty.get(propertyName));
	}
	/**
	 * 取得配置文件的对象值
	 * @param propertyName :对象名称
	 * @return 对象值
	 */
	public static int getPropertyByInt(String propertyName) {
		return Integer.parseInt(ConfigurationHelper.getPropertyByStr(propertyName));
	}
	/**
	 * getVerCode:获取config.properties里的省份编码. <br/> 
	 * @author wchhuangya
	 * @return
	 */
	public static String getVerCode() {
		try {
			return "_" + ConfigurationHelper.getPropertyByStr("platform.code");
		} catch (Exception e) {
			e.printStackTrace();
			return "_JT";
		}
	}
	
    /**
     * 获取短信验证下发号码
     * @return
     */
    public static String getSmsVerNumber(){
        return String.valueOf(ConfigurationHelper.getPropertyByStr("smsver.number"));
    }
}
