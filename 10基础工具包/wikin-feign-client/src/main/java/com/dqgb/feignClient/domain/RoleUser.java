package com.dqgb.feignClient.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色用户包装类
 * 
 * @className RoleUser
 * @author :技术部-zhangjs
 * @Description
 * @date 2019年9月26日 下午11:27:12
 */
@Data
@Accessors(chain = true)
public class RoleUser {
	/**
	 * 角色ID
	 */
	private String roleID;
	/**
	 * 用户Id
	 */
	private String userID;
	/**
	 * 当前页
	 */
	private Integer page = 0;
	/**
	 * 分页大小
	 */
	private Integer size = Integer.MAX_VALUE;
	/**
	 * 排序字段
	 */
	private String sortProperty = "modifyTime";
	/**
	 * 排序方式
	 */
	private String sortDerect = "DESC";
}
