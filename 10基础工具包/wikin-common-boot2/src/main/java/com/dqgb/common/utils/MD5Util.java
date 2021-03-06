package com.dqgb.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.codec.Hex;

import com.dqgb.common.domain.Encrypt;

/**
 * 
 * ClassName: MD5Util <br/>
 * Function: 密码加盐处理工具类<br/>
 * date: 2018年2月11日 上午10:54:11 <br/>
 *
 * @author wenzhang
 * @version
 * @see [相关类/方法]
 * @Description:
 * @since JDK 1.8
 */
public class MD5Util {

	private final static String[] arr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4",
			"5", "6", "7", "8", "9" };

	/**
	 * 
	 * @Description:费用的加盐方法，已不用
	 *
	 * @author wenzhang
	 * @date:2018年2月11日 上午10:55:00
	 * @Title:encrypt
	 * @param dataStr
	 * @return
	 * @since JDK 1.8
	 */
	public static String encrypt(String dataStr) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(dataStr.getBytes("UTF8"));
			byte s[] = m.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
			}
			return result;
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return "";
	}

	/**
	 * 加盐MD5
	 * 
	 * @author daniel
	 * @time 2016-6-11 下午8:45:04
	 * @param password
	 * @return
	 */
	public static Encrypt generate(String password) {
		String salt = getSalt();
		String md5Passwd = md5Hex(password + salt);
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = md5Passwd.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = md5Passwd.charAt(i / 3 * 2 + 1);
		}
		String finalPasswd = new String(cs);
		Encrypt encrypt = new Encrypt();
		encrypt.setPassword(password);
		encrypt.setSalt(salt);
		encrypt.setMd5Passwd(finalPasswd);
		return encrypt;
	}

	/**
	 * 校验加盐后是否和原文一致
	 * 
	 * @author daniel
	 * @time 2016-6-11 下午8:45:39
	 * @param password
	 * @param md5
	 * @return
	 */
	public static boolean verify(String password, String md5) {
		char[] cs1 = new char[32];
		char[] cs2 = new char[16];
		for (int i = 0; i < 48; i += 3) {
			cs1[i / 3 * 2] = md5.charAt(i);
			cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
			cs2[i / 3] = md5.charAt(i + 1);
		}
		String salt = new String(cs2);
		return md5Hex(password + salt).equals(new String(cs1));
	}

	
	
	
	/**
	 * 获取十六进制字符串形式的MD5摘要
	 */
	public static String md5Hex(String src) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest(src.getBytes());
			return new String(new Hex().encode(bs));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 獲取16位的盐
	 * 
	 * @return
	 */
	private static String getSalt() {
		StringBuilder sb = new StringBuilder(16);
		Random r = new Random();
		for (int i = 0; i < 16; i++) {
			int index = r.nextInt(arr.length);
			sb.append(arr[index]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @Description:对字符串进行base64解编码.
	 *
	 * @author Administrator
	 * @date:2018年6月1日 上午11:31:08
	 * @Title:base64Decode
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 * @since JDK 1.8
	 */
	public static String base64Decode(String str) throws UnsupportedEncodingException {
		byte[] bytes = Base64.decodeBase64(str.getBytes("UTF-8"));
		return new String(bytes);
	}
	
	/**
	 * 加密
	* @Title encode
	* @author yangxi
	* @Description: 
	* @date 2018年12月10日
	* @param s
	* @return
	 */
//	  public static String encode(String s) {
//	        if (s == null)
//	            return null;
//	        String res = "";
//	        try {
//	            res = new sun.misc.BASE64Encoder().encode(s.getBytes("UTF-8"));
//	        } catch (UnsupportedEncodingException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//	        return res;
//	    }

}
