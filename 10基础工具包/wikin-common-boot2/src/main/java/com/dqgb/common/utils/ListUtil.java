package com.dqgb.common.utils;

import java.util.List;

import org.apache.commons.collections.ListUtils;

/**
 * 
 * ClassName: ListUtil <br/>
 * Function: 集合处理工具类. <br/>
 * date: 2018年2月11日 上午10:57:06 <br/>
 *
 * @author yangmaoli
 * @version
 * @see [相关类/方法]
 * @Description:
 * @since JDK 1.8
 */
public abstract class ListUtil extends ListUtils {

	/**
	 * 判断是否为null或者长度为0的空集合
	 * 
	 * @Title isEmpty
	 * @author yangmaoli
	 * @Description:
	 * @date 2013-12-6
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list) {
		return list == null || list.isEmpty();
	}

	/**
	 * @Title isNotEmpty
	 * @author :技术部-yangmaoli
	 * @Description 不为null并且数据不为0
	 * @date 2019年4月28日 下午4:40:30
	 * @param list
	 * @return
	 */
	public static boolean isNotEmpty(List list) {
		return null != list && list.size() > 0;
	}
}
