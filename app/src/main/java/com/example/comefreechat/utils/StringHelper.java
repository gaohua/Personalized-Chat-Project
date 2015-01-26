package com.example.comefreechat.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 
 * <p>
 * 字符串帮助类
 * </p>
 * 
 * @company 中国电信甘肃万维公司
 * 
 * @project nma-c-android
 * 
 * @version V2.0.0
 * 
 * @author ht
 * 
 * @date 2012-8-13 上午10:08:57
 * 
 * @class com.gsww.util.StringHelper
 * 
 */
public class StringHelper {
	/**
	 * 过滤HTML标签
	 * 
	 * @param content
	 * @return
	 */
	public static String dealHtml(String content) {
		Pattern pt = Pattern.compile("<[^>]*>");
		content = content.replaceAll(pt.pattern(), "");
		if (content.indexOf("&ldquo;") > -1) {
			content = content.replaceAll("&ldquo;", "“");
		}
		if (content.indexOf("&rdquo;") > -1) {
			content = content.replaceAll("&rdquo;", "”");
		}

		if (content.indexOf("&lsquo;") > -1) {
			content = content.replaceAll("&lsquo;", "’");
		}
		if (content.indexOf("&rsquo;") > -1) {
			content = content.replaceAll("&rsquo;", "‘");
		}

		if (content.indexOf("&sbquo;") > -1) {
			content = content.replaceAll("&sbquo;", "，");
		}

		if (content.indexOf("&quot;") > -1) {
			content = content.replaceAll("&quot;", "\"");
		}
		if (content.indexOf("&amp;") > -1) {
			content = content.replaceAll("&amp;", "&");
		}
		if (content.indexOf("&lt;") > -1) {
			content = content.replaceAll("&lt;", "<");
		}
		if (content.indexOf("&gt;") > -1) {
			content = content.replaceAll("&gt;", ">");
		}
		if (content.indexOf("&nbsp;") > -1) {
			content = content.replaceAll("&nbsp;", "");
		}
		return content;
	}

	/**
	 * 处理正文中的特殊字符
	 * 
	 * @param str
	 * @return
	 */
	public static String dealSpecial(String str) {
		char[] char_arr = str.toCharArray();
		int[] pos = new int[10000];
		for (int i = 0; i < pos.length; i++)
			pos[i] = -1;
		int j = 0;
		for (int i = 0; i < char_arr.length; i++) {
			if ((int) char_arr[i] == 10 || (int) char_arr[i] == 13) {
				pos[j++] = i;
			}
		}
		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < pos.length; i++) {
			if (pos[i] != -1) {
				sb.insert(pos[i] + i * (5 - 1), "<br/>");
				sb.replace(pos[i] + i * (5 - 1) + 5, pos[i] + i * (5 - 1) + 5
						+ 1, "");
			}
		}
		return sb.toString();
	}

	/**
	 * 根据传入的正则表达式数组里的内容，判断传入的字符串是否符合正则表达式的要求
	 * 
	 * @param checkedStr
	 *            -- 传入的要被检查的字符串
	 * @param regStr
	 *            -- 要匹配的正则表达式数组
	 * @return -- 如果符合正则表达式的要求，返回true;如果不符合正则表达式的要求，返回false
	 */
	public static Boolean ifMeetRequire(final String checkedStr,
			final String[] regStr) {
		Boolean res = false;
		for (String s : regStr) {
			if (checkedStr.matches(s)) {
				res = true;
				break;
			}
		}
		return res;
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || str.trim().equals(""))
			return true;
		else
			return false;
	}

	/**
	 * 字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * object 转 String
	 * @param obj
	 * @return
	 */
	public static String convertToString(Object obj) {
		if (obj == null)
			return "";
		String str = obj.toString().trim();
		if (str.equals("null") || str.equals("NULL"))
			return "";
		return str;
	}

	/**
	 * 半角转换为全角
	 * 
	 * @param input
	 * @return
	 */
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 获取百分比
	 * 
	 * @param p1
	 * @param p2
	 * @param decimals
	 * @return
	 */
	public static String getPercent(double p1, double p2, int decimals) {
		if (p2 <= p1) {
			return "100%";
		} else {
			double p3 = p1 / p2;
			NumberFormat nf = NumberFormat.getPercentInstance();
			if (decimals > 0)
				nf.setMinimumFractionDigits(decimals);
			return nf.format(p3);
		}
	}

	/**
	 * 获取百分比
	 * 
	 * @param p1
	 * @param p2
	 * @param decimals
	 * @return
	 */
	public static double getPercent2(double p1, double p2, int decimals) {
		double p3 = p1 / p2;
		/*if (p3 <1) {
			p3 = p3 *100;
		}*/
		// 设置位数
		int roundingMode = 4;// 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
		BigDecimal bd = new BigDecimal(p3 * 100);
		
		bd = bd.setScale(decimals, roundingMode);
		return bd.doubleValue();
	}
	
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
