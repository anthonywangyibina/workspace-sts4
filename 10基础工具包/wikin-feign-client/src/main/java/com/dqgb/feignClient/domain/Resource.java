package com.dqgb.feignClient.domain;

import lombok.Data;

/**
 * 资源实体
 *@className Resource
 *@author :技术部-zhangjs
 *@Description  资源实体
 *@date 2019年9月23日 下午2:00:40
 */
@Data
public class Resource {
	/**
	 * userId 主键
	 */
	private String id;
	/**
	 * 菜单所属模块
	 */
	private String resourceModule;
	/**
	 * 父ID
	 */
	private String resourcePid;
	/**
	 * 资源名称
	 */
	private String resourceName;
	/**
	 * 资源编码
	 */
	private String resourceCode;
	/**
	 * 资源URL
	 */
	private String resourceUrl;
	/**
	 * url请求方式
	 */
	private String resourceMethod;
	/**
	 * 资源排序
	 */
	private String resourceOrder;
	/**
	 * 图标
	 */
	private String resourceIcon;
	/**
	 * 资源类型
	 */
	private String resourceType;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 修改时间
	 */
	private String modifyTime;
	/**
	 * 操作人
	 */
	private String operatePerson;
	/**
	 * 是否删除
	 */
	private String isDeleted;
	/**
	 * 资源英文名称
	 */
	private String english;
	/**
	 * 所属服务
	 */
	private String serviceCode;
	/**
	 * 菜单加载方式：iframe/div
	 */
	private String loadMethod;
	/**
	 * 资源类型中文名
	 */
	private String type;
	/**
	 * 登陆方式
	 */
	private String loginType;
	/**
	 * 前端路由地址
	 */
	private String reactUrl;
}
