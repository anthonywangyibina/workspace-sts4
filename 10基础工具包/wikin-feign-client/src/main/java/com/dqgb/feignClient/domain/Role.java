package com.dqgb.feignClient.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色实体
 * 
 * @className Role
 * @author :技术部-zhangjs
 * @Description 角色相关信息
 * @date 2019年9月19日 上午11:19:18
 */
@Data
@Accessors(chain = true)
public class Role {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 角色编码
	 */
	private String code;
	/**
	 * 资源权限
	 */
	private String rightsResource;
	/**
	 * 角色可以使用的系统
	 */
	private String rightsSys;
	/**
	 * 角色所属的系统
	 */
	private String roleSys;
	/**
	 * 角色是否为超级管理员
	 */
	private String roleIsSys;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后修改时间
	 */
	private String modifyTime;
	/**
	 * 创建人
	 */
	private String operatePerson;
	/**
	 * 说明
	 */
	private String description;
	/**
	 * 角色模糊查询时默认当前为0页
	 */
	private Integer page=0;
	/**
	 * 角色模糊查询默认只查询一条符合要求的数据
	 */
	private Integer size=1;
	/**
	 * 角色模糊查询默认排序字段
	 */
	private String sortProperty="modifyTime";
	/**
	 * 角色模糊查询默认排序方式
	 */
	private String sortOrder="DESC";

}
