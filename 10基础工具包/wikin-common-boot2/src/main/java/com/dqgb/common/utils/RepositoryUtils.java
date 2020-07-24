package com.dqgb.common.utils;

public abstract class RepositoryUtils {
	/**
	 * @Title getPropertyWildcardValue
	 * @author Mr.Wang
	 * @Description: 前后通配
	 * @date 2017年5月4日
	 * @param property
	 * @return
	 */
	public static String getPropertyWildcardValue(String property) {
		return "%" + property + "%";
	}

	/**
	 * @Title getPropertyFrontMatchValue
	 * @author Mr.Wang
	 * @Description: 前匹配
	 * @date 2017年5月4日
	 * @param property
	 * @return
	 */
	public static String getPropertyFrontMatchValue(String property) {
		return "%" + property;
	}

	/**
	 * @Title getPropertyBehandMatchValue
	 * @author Mr.Wang
	 * @Description: 后匹配
	 * @date 2017年5月4日
	 * @param property
	 * @return
	 */
	public static String getPropertyBehandMatchValue(String property) {
		return property + "%";
	}
	/**
	* @Title escapeQueryValue
	* @author yangmaoli
	* @Description: 模糊查询转义
	* @date 2018年10月12日
	* @param property
	* @return
	*/ 
	public static String escapeQueryValue(String property) {
		if(StringUtil.isNotBlank(property)){
			property = property.replace("\\","\\\\"); 
			property = property.replaceAll("_", "\\\\_"); 
			property = property.replaceAll("%", "\\\\%");     			
		}
		return property;
	}
	

}
