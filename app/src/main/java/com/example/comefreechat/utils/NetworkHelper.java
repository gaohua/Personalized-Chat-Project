package com.example.comefreechat.utils;

import java.lang.reflect.Method;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * 类名: NetworkHelper <br/> 
 * 功能: 网络设置帮助类. <br/> 
 * 创建时间: 2014-9-16 下午3:34:26 <br/> 
 * 
 * @author wchhuangya 
 * @version  
 * @since Jdk 1.6
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class NetworkHelper {

	/**
	 * 判断是否联网
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = manager.getActiveNetworkInfo();
		return (info != null && info.isConnected());
	}

	/**
	 * 判断是否3g联网
	 * @param context
	 * @return
	 */
	public static boolean is3GConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = manager.getActiveNetworkInfo();
		if (info != null && info.isConnected()) {
			return info.getType() == ConnectivityManager.TYPE_MOBILE;
		}
		return false;
	}

	/**
	 * wifi 开关
	 * @param context
	 */
	public static void toggleWifi(Context context, boolean isOpen) {
		WifiManager mWifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		if (mWifiManager.isWifiEnabled() && isOpen) {
			Toast.makeText(context, "Wifi已经打开!", Toast.LENGTH_SHORT).show();
		} else if (!mWifiManager.isWifiEnabled() && !isOpen) {
			Toast.makeText(context, "Wifi已经关闭!", Toast.LENGTH_SHORT).show();
		} else {
			mWifiManager.setWifiEnabled(isOpen);
		}
	}

	/**
	 * 3g 开关
	 * @param context
	 * @param isOpen
	 */
	public static void toggle3G(Context context, boolean isOpen) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (ConnectivityManager
				.isNetworkTypeValid(ConnectivityManager.TYPE_MOBILE)) {
			Object[] arg = null;
			try {
				boolean isMobileDataEnable = invokeMethod(manager,
						"getMobileDataEnabled", arg);

				if (isMobileDataEnable && isOpen) {
					Toast.makeText(context, "3G已经打开!", Toast.LENGTH_SHORT)
							.show();
				} else if (!isMobileDataEnable && !isOpen) {
					Toast.makeText(context, "3G已经关闭!", Toast.LENGTH_SHORT)
							.show();
				} else {
					invokeBooleanArgMethod(manager, "setMobileDataEnabled",
							isOpen);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Toast.makeText(context, "当前3g网络不可用!", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 通过反射调用方法
	 * 
	 * @param manager
	 * @param methodName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	private static boolean invokeMethod(ConnectivityManager manager,
			String methodName, Object[] arg) throws Exception {

		Class ownerClass = manager.getClass();
		Class[] argsClass = null;
		if (arg != null) {
			argsClass = new Class[1];
			argsClass[0] = arg.getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return (Boolean) method.invoke(manager, arg);
	}

	/**
	 * 通过反射调用方法
	 * 
	 * @param manager
	 * @param methodName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	private static Object invokeBooleanArgMethod(ConnectivityManager manager,
			String methodName, boolean value) throws Exception {
		Class ownerClass = manager.getClass();
		Class[] argsClass = new Class[1];
		argsClass[0] = boolean.class;
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(manager, value);
	}
}
