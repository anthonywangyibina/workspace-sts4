package com.dqgb.feignClient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 	业务日志实体
 *@className BusinessLog
 *@author :技术部-zhangjs
 *@Description  业务日志实体
 *@date 2019年9月23日 下午1:55:01
 */
@Data
public class BusinessLog {

	/**
	 * 操作数据的ID:多个用逗号隔开
	 */
	private String dataId;

	/**
	 * 操作详情
	 */
	private String operateDetail;
	/**
	 * 操作：如删除用户、添加角色
	 */
	private String operateName;

	/**
	 * 操作地ip
	 */
	private String operateIp;

	/**
	 * 所属业务：如角色管理、巡检记录等
	 */
	private String businessType;

	/**
	 * 操作时间
	 */
	private Date operateTime;

	/**
	 * 操作人姓名+账号：如，管理员(admin)
	 */
	private String operateUser;

	/**
	 * 所属业务编码
	 */
	private String bussinessCode;

	/**
	 * 所属应用编码
	 */
	private String applyCode;

	/**
	 * 所属应用名
	 */
	private String applyName;
	/**
	 * 查询业务日志默认分页信息
	 */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer page = 0;
	/**
	 * 分页大小
	 */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer size = 15;
	/**
	 * 排序字段
	 */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String sortProperty = "operateTime";
	/**
	 * 排序方式
	 */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String sortDerect = "DESC";
}
