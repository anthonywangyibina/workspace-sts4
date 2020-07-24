package com.dqgb.feignClient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * 组织（部门）实体
 *@className Org
 *@author :技术部-zhangjs
 *@Description  组织实体
 *@date 2019年9月23日 下午2:00:13
 */
@Data
public class Org {
	/**
	 * 部门名称
	 */
	@JsonProperty(value = "DEPARTMENT_NAME",required = false)
	private String name;
	/**
	 * 是否被删除
	 */
	@JsonProperty(value = "IS_DELETED",required = false)
	private String isDeleted;
	/**
	 * 部门类型编码
	 */
	@JsonProperty(value = "ORGTYPE_DICT_CODE",required = false)
	private String orgTypeDictCode;
	/**
	 * 创建人
	 */
	@JsonProperty(value = "CREATE_USER",required = false)
	private String createUser;
	/**
	 * 父Id
	 */
	@JsonProperty(value = "FK_DEPARTMENT_ID",required = false)
	private String parentId;
	/**
	 * 编码
	 */
	@JsonProperty(value = "DEPARTMENT_CODE",required = false)
	private String code;
	/**
	 * 描述
	 */
	@JsonProperty(value = "DESCRIPTION",required = false)
	private String description;
	/**
	 * 修改时间
	 */
	@JsonProperty(value = "MODIFY_DATE",required = false)
	private String modifyDate;
	/**
	 * 类型
	 */
	@JsonProperty(value = "ORGTYPE",required = false)
	private String type;
	/**
	 * 排序
	 */
	@JsonProperty(value = "SORT",required = false)
	private String sort;
	/**
	 * 部门领导人Id
	 */
	@JsonProperty(value = "FK_LEADER_USER_ID",required = false)
	private String leaderUserId;
	/**
	 * 来源
	 */
	@JsonProperty(value = "ORG_FROM",required = false)
	private String orgFrom;
	@JsonProperty(value = "ID",required = false)
	/**
	 * 主键
	 */
	private String id;
	@JsonProperty(value = "CREATETIME",required = false)
	/**
	 * 创建时间
	 */
	private String createTime;
	@JsonProperty(value = "MODIFY_USER",required = false)
	/**
	 * 修改人
	 */
	private String modifyUser;
	/**
	 * 层级
	 */
	@JsonProperty(value = "HIERARCHY",required = false)
	private String hierarchy;
}
