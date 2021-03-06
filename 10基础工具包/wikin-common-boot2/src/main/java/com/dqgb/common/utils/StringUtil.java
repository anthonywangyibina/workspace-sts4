package com.dqgb.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * ClassName: StringUtil <br/>
 * Function: 字符串处理工具类. <br/>
 * date: 2018年2月11日 上午10:57:06 <br/>
 *
 * @author wenzhang
 * @version
 * @see [相关类/方法]
 * @Description:
 * @since JDK 1.8
 */
public abstract class StringUtil extends StringUtils {

	/**
	 * 判断是否为null或者长度为0的空字符串
	 * 
	 * @Title isEmpty
	 * @author wanglc
	 * @Description:
	 * @date 2013-12-6
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 字符串转化小写
	 * 
	 * @Title getLowerStr
	 * @author wanglc
	 * @Description:
	 * @date 2013-12-6
	 * @param str
	 * @return
	 */
	public static String getLowerStr(String str) {
		return str.toLowerCase();
	}

	/**
	 * 字符串转化大写
	 * 
	 * @Title getUpperStr
	 * @author wanglc
	 * @Description:
	 * @date 2013-12-6
	 * @param str
	 * @return
	 */
	public static String getUpperStr(String str) {
		return str.toUpperCase();
	}

	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * 
	 * @Title replaceBlank
	 * @author wanglc
	 * @Description:
	 * @date 2013-12-6
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("").replaceAll("　", "");
		}
		return dest;
	}

	/**
	 * 
	 * @Description:按照格式切割字符串。若出现异常或空，则返回null
	 *
	 * @author wenzhang
	 * @date:2018年2月11日 上午10:57:50
	 * @Title:split
	 * @param str
	 *            需要切割的字符串
	 * @param regex
	 *            切割格式
	 * @return 字符串数组
	 * @since JDK 1.8
	 */
	public static String[] split(String str, String regex) {
		if (StringUtil.isBlank(str) || StringUtil.isBlank(regex)) {
			return null;
		}
		String[] strArray = str.split(regex);
		if (strArray != null && strArray.length > 0) {
			return strArray;
		} else {
			return null;
		}
	}
	
	/**
	 * 字符串数组元素以,连接
	 * @param arr 字符串数组
	 * @return
	 */
	public static String arrToString(String[] arr) {
		try{
			StringBuffer sb = new StringBuffer();
			if (null != arr && arr.length > 0) {
				for (String str : arr) {
					sb.append(str + ",");
				}
				return sb.toString();
			} else {
				return "";
			}
		}catch(Exception e){
			return "";
		}
	}

	/**
	 * 对传入的字符串进行修正(null,>>>化为>>>null)
	 * 
	 * @Title fixup
	 * @author yangmaoli
	 * @Description:
	 * @date 2013-12-6
	 * @param in
	 * @return
	 */
	public static String fixup(String in) {
		return in == null ? "" : in;
	}

	/**
	 * 对传入的对象进行修正(null||o.toString()为"null"==>>>null) AND ISO2GBK
	 * 
	 * @Title fixup
	 * @author yangmaoli
	 * @Description:
	 * @date 2013-12-6
	 * @param o
	 * @return
	 */
	public static String fixup(Object o) {
		if (o instanceof java.sql.Timestamp) {
			String time = o.toString();
			return time.lastIndexOf("00:00:00.0") != -1 ? time.substring(0, 10) : time.substring(0, 19);

		}
		return o == null ? "" : o.toString();
	}
}
