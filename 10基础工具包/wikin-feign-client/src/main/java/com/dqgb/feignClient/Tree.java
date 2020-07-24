package com.dqgb.feignClient;

import java.util.List;

import lombok.Data;

/**
 * 树结构
 *@className Tree
 *@author :技术部-zhangjs
 *@Description  
 *@date 2019年9月26日 下午9:19:16
 */
@Data
public class Tree<T> {
	/**
	 * userId 主键
	 */
	private String nodeld;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * 节点编码
	 */
	private String nodeCode;
	/**
	 * 节点类型
	 */
	private String nodeType;
	/**
	 * 子节点
	 */
	private List<Tree<T>> list;

}
