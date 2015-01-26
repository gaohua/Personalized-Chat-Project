package com.example.comefreechat.utils;



 
import java.io.InputStream;
import java.util.Properties;

/**
 * 客户端配置
 * @author ht
 * @date   2012-5-2
 */
public class Configuration {
    private static Properties defaultProperty;

    static {
        init();
    }

    static void init() {
        defaultProperty = new Properties();
        InputStream stream =
        	Configuration.class.getResourceAsStream("/assets/config.properties");
		try {
			defaultProperty.load(stream);
		} catch (Exception e) {

		}
		defaultProperty.putAll(System.getProperties());
    }
    
    /**
	 * @param propertyName :对象名称
	 * @return 对象值
	 * 取得配置文件的对象值
	 */
	public static String getPropertyByStr(String propertyName) {
		return String.valueOf(Configuration.defaultProperty.get(propertyName));
	}
	/**
	 * @param propertyName :对象名称
	 * @return 对象值
	 * 取得配置文件的对象值
	 */
	public static int getPropertyByInt(String propertyName) {
		return Integer.parseInt(Configuration.getPropertyByStr(propertyName));
	}
   
}
