package com.dqgb.feignClient;

import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;

/**
 * 分页信息
 * 
 * @className Page
 * @author :技术部-zhangjs
 * @Description 分页信息
 * @date 2019年9月26日 下午9:12:26
 */
@Data
public class Page<T> {
	/**
	 * 内容
	 */
	private List<T> content;
	/**
	 * 总记录数
	 */
	private String totalElements;
	/**
	 * 当前是否为最后一页
	 */
	private Boolean last;
	/**
	 * 总页数
	 */
	private String totalPages;
	/**
	 * 排序信息
	 */
	private Object sort;
	/**
	 * 当前页中元素数
	 */
	private String numberOfElements;
	/**
	 * 当前页是否第一页
	 */
	private Boolean first;
	/**
	 * 分页大小
	 */
	private Integer size;
	/**
	 * 当前的页码
	 */
	private Integer number;

	public boolean isEmplty() {
		return CollectionUtils.isEmpty(content);
	}
}
